<template>
    <HeaderView></HeaderView>
    <div class="login-content">
        <div class="login-flex">
            <div class="login-left"></div>
            <!---->
            <div class="login-box">
                <h3 class="login-title">实名认证</h3>
                <form action="" id="renZ_Submit">
                    <div class="alert-input">
                        <input type="text" class="form-border user-name" v-model="username" placeholder="请输入您的真实姓名" />
                        <p class="prompt_name"></p>
                        <input type="text" class="form-border user-sfz" v-model="sfz" placeholder="请输入15位或18位身份证号" />
                        <p class="prompt_sfz"></p>
                        <input type="text" class="form-border user-num" v-model="mobile" placeholder="请输入11位手机号" />
                    </div>
                    <br />
                    <div class="alert-input-agree">
                        <i class="fa fa-square-o"></i>我已阅读并同意<a href="javascript:;" target="_blank">《动力金融网注册服务协议》</a>
                    </div>
                    <div class="alert-input-btn">
                        <input type="submit" class="login-submit" value="认证" />
                    </div>
                </form>
                <div class="login-skip">
                    暂不认证？ <router-link to="/">跳过</router-link>
                </div>
            </div>
        </div>
    </div>
    <FooterView></FooterView>
</template>
<script>
import HeaderView from "@/views/common/HeaderView";
import FooterView from "@/views/common/FooterView";
import { myajax } from "@/utils/myaxios";
import { showFailToast, showSuccessToast,showLoadingToast,closeToast } from 'vant';

export default {
    name: "AttestationView",
    components: {
        HeaderView,
        FooterView,
    },
    data() {
        return {
            mobile: "",
            username: "",
            sfz: "",
        };
    },
    methods: {
        getCode() {
            var regPhone = /^[1][3456789][0-9]{9}$/;
            var regSfz18 = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
            var regSfz15 = /^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$/;
            if (this.username != "") {
                if (regSfz18.test(this.sfz) || regSfz15.test(this.sfz) && regPhone.test(this.mobile)) {
                    showLoadingToast({
                    duration: 0,
                    forbidClick: true,
                    message: "认证请求中..."
                });
                    myajax({
                        url: "/attestation",
                        method: "POST",
                        headers: {
                            token: localStorage.getItem('token')
                        },
                        data: {
                            mobile: this.mobile,
                            username: this.username,
                            idCard: this.sfz
                        }
                    }).then((res) => {
                        if (res.data.code == 200) {
                            closeToast(true);
                            showSuccessToast("认证成功");
                            this.$router.push("/");
                        } else {
                            closeToast(true);
                            showFailToast(res.data.msg);
                        }
                    }).catch((e) => {
                        closeToast(true);
                        showFailToast(e);
                    })
                }
            } else {
                closeToast(true);
                showFailToast("信息填写有误");
            }
        }
    },
}
</script>
<style>

</style>