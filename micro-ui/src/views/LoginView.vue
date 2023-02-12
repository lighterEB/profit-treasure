<template>
    <div>
        <HeaderView></HeaderView>
        <div class="login-content">
            <div class="login-flex">
                <div class="login-left">
                    <h3>加入动力金融网</h3>
                    <p>
                        坐享<span>{{ hotData.hotRate }}%</span>历史年化收益
                    </p>
                    <p>
                        平台用户<span>{{ hotData.hotCountUser }}</span>位
                    </p>
                    <p>
                        累计成交金额<span>{{ hotData.hotCountBidMoney }}</span>元
                    </p>
                </div>
                <!---->
                <div class="login-box">
                    <h3 class="login-title">欢迎登录</h3>
                    <form action="" id="login_Submit">
                        <div class="alert-input">
                            <!--<input class="form-border user-name" name="username" type="text" placeholder="您的姓名">
                    <p class="prompt_name"></p>-->
                            <input type="number" class="form-border user-num" v-model="mobile"
                                placeholder="请输入11位手机号" />
                            <p class="prompt_num"></p>
                            <input type="password" placeholder="请输入登录密码" class="form-border user-pass" autocomplete
                                v-model="password" />
                            <p class="prompt_pass"></p>
                            <div class="form-yzm form-border">
                                <input class="yzm-write" type="text" placeholder="输入短信验证码" v-model="code" />
                                <sapn class="yzm-send" type="text" id="yzmBtn" v-if="codeShow" style="color: red"
                                    @click="getCode">获取验证码</sapn>
                                <span type="text" id="yzmBtn" readonly="readonly" v-if="!codeShow"
                                    style="font-size: 1px; text-align: left">{{ count }}秒后重新发送</span>
                            </div>
                            <p class="prompt_yan"></p>
                        </div>
                        <div class="alert-input-btn">
                            <input type="button" class="login-submit" value="登录" @click="toLogin" />
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <FooterView></FooterView>
    </div>
</template>
<script>
import HeaderView from "@/views/common/HeaderView";
import FooterView from "@/views/common/FooterView";
import { showSuccessToast, showFailToast,showLoadingToast,showConfirmDialog,closeToast } from "vant";
import { myajax } from "@/utils/myaxios";
import { numFilter } from "@/filters/myfilter";

export default {
    name: "LoginView",
    components: {
        HeaderView,
        FooterView,
    },
    data() {
        return {
            codeShow: true,
            count: "",
            timer: null,
            mobile: "",
            password: "",
            code: "",
            hotData: {
                hotRate: 0,
                hotCountBidMoney: 0,
                hotCountUser: 0,
            },
        };
    },
    methods: {
        getCode() {
            var regPhone = /^[1][3456789][0-9]{9}$/;
            var regPwd = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^\w]).{8,16}$/;
            if (regPhone.test(this.mobile)) {
                if (regPwd.test(this.password)) {
                    showSuccessToast("验证码已发送");
                    const TIME_COUNT = 60;
                    if (!this.timer) {
                        this.count = TIME_COUNT;
                        this.codeShow = false;
                        this.timer = setInterval(() => {
                            if (this.count > 0 && this.count <= TIME_COUNT) {
                                this.count--;
                            } else {
                                this.codeShow = true;
                                clearInterval(this.timer);
                                this.timer = null;
                            }
                        }, 1000);
                    }
                } else {
                    showFailToast("密码必须为8-16位数字、大写字母、小写字母、字符组合");
                }
                // let code = {
                //     mobile: this.mobile,
                //     sms_type: "login"
                // }
            } else {
                showFailToast("手机号码格式不正确");
            }
        },
        toLogin() {
            if (this.phone != "" && this.code != "" && this.password != "") {
                showLoadingToast({
                    duration: 0,
                    forbidClick: true,
                    message: "正在登录..."
                });
                myajax({
                    url: "/login",
                    method: "POST",
                    params: {
                        phone: this.mobile,
                        code: this.code,
                        password: this.password
                    },
                }).then((res) => {
                    if (res.data.code == 200) {
                        let data = res.data.data;
                        localStorage.setItem("token", data.token);
                        localStorage.setItem("money", data.money);
                        localStorage.setItem("phone", data.phone);
                        localStorage.setItem("name", data.name);
                        localStorage.setItem("idCard", data.idCard);
                        if (data.name == "null" || data.idCard == "null") {
                            closeToast(true);
                            showConfirmDialog({
                                title: '登录信息',
                                message: '该账号尚未实名认证，将影响投资、充值等功能，是否立即认证？'
                            }).then(() => {
                                this.$router.push("/attestation");
                            }).catch(() => {
                                this.$router.push("/");
                            })
                        } else {
                            closeToast(true);
                            showSuccessToast('登陆成功');
                            this.$router.push("/");
                        }
                    }else{
                        showFailToast(res.data.message);
                    }
                }).catch((error)=>{
                    closeToast(true);
                    showFailToast(error);
                });
            } else {
                showFailToast("请正确填写信息");
            }
        },
    },
    mounted() {
        myajax({
            url: "/hot",
            method: "GET",
        }).then((res) => {
            if (res.data.code == 200) {
                this.hotData = res.data.data;
                this.hotData.hotRate = numFilter(this.hotData.hotRate);
            } else {
                alert(res.data.message);
            }
        });
    },
};
</script>
