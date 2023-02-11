<template>
    <div>
        <HeaderView></HeaderView>
        <div class="login-content">
    <div class="login-flex">
        <div class="login-left">
            <h3>加入动力金融网</h3>
            <p>坐享<span>12.7%</span>历史年化收益</p>
            <p>平台用户<span>539</span>位  </p>
            <p>累计成交金额<span>130000</span>元</p>
        </div>
        <!---->
        <div class="login-box">
            <h3 class="login-title">欢迎登录</h3>
            <form action="" id="login_Submit">
                <div class="alert-input">
                    <!--<input class="form-border user-name" name="username" type="text" placeholder="您的姓名">
                    <p class="prompt_name"></p>-->
                    <input type="number" class="form-border user-num" v-model="mobile" placeholder="请输入11位手机号">
                    <p class="prompt_num"></p>
                    <input type="password" placeholder="请输入登录密码" class="form-border user-pass" autocomplete v-model="password">
                    <p class="prompt_pass"></p>
                    <div class="form-yzm form-border">
                        <input class="yzm-write" type="text" placeholder="输入短信验证码">
                        <input class="yzm-send" type="text" value="获取验证码"  id="yzmBtn" v-if="codeShow" style="color:red;" @click="getCode" >
                        <span  type="text" id="yzmBtn" readonly="readonly" v-if="!codeShow"  style="font-size: 1px; text-align: left;" >{{ count }}秒后重新发送</span>
                    </div>
                    <p class="prompt_yan"></p>
                </div>
                <div class="alert-input-btn">
                    <input type="button" class="login-submit" value="登录">
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
import { showToast } from 'vant';

export default {
  name: "LoginView",
  components: {
    HeaderView,FooterView
  },
  data() {
    return {
        codeShow: true,
        count: '',
        timer:null,
        mobile: "",
    };
  },
  methods: {
    getCode() {
        var reg = /^[1][3456789][0-9]{9}$/
        if(reg.test(this.mobile)) {
            showToast('验证码已发送')
            this.$showFail
            const TIME_COUNT = 60;
            if (!this.timer) {
                this.count = TIME_COUNT;
                this.codeShow = false;
                this.timer = setInterval(() => {
                    if(this.count > 0 && this.count<=TIME_COUNT) {
                        this.count--;
                    }else {
                        this.codeShow = true;
                        clearInterval(this.timer);
                        this.timer = null;
                    }
                }, 1000)
            }
            // let code = {
            //     mobile: this.mobile,
            //     sms_type: "login"
            // }
        }else {
            showToast('手机号码格式不正确');
        }
    }
  },
  mounted() {
  },
};
</script>
