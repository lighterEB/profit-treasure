<template>
  <div>
    <HeaderView></HeaderView>
    <div class="login-content">
      <div class="login-flex">
        <div class="login-left">
          <h3>加入动力金融网</h3>
          <p>坐享<span>{{ hotData.hotRate }}%</span>历史年化收益</p>
          <p>平台用户<span>{{ hotData.hotCountUser }}</span>位</p>
          <p>累计成交金额<span>{{ hotData.hotCountBidMoney }}</span>元</p>
        </div>
        <!---->
        <div class="login-box">
          <h3 class="login-title">欢迎登录</h3>
          <form action="" id="login_Submit">
            <div class="alert-input">
              <!--<input class="form-border user-name" name="username" type="text" placeholder="您的姓名">
                    <p class="prompt_name"></p>-->
              <input
                type="number"
                class="form-border user-num"
                v-model="mobile"
                placeholder="请输入11位手机号"
              />
              <p class="prompt_num"></p>
              <input
                type="password"
                placeholder="请输入登录密码"
                class="form-border user-pass"
                autocomplete
                v-model="password"
              />
              <p class="prompt_pass"></p>
              <div class="form-yzm form-border">
                <input
                  class="yzm-write"
                  type="text"
                  placeholder="输入短信验证码"
                />
                <sapn
                  class="yzm-send"
                  type="text"
                  id="yzmBtn"
                  v-if="codeShow"
                  style="color: red"
                  @click="getCode"
                  >获取验证码</sapn
                >
                <span
                  type="text"
                  id="yzmBtn"
                  readonly="readonly"
                  v-if="!codeShow"
                  style="font-size: 1px; text-align: left"
                  >{{ count }}秒后重新发送</span
                >
              </div>
              <p class="prompt_yan"></p>
            </div>
            <div class="alert-input-btn">
              <input type="button" class="login-submit" value="登录" />
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
import { showSuccessToast, showFailToast } from "vant";
import {myajax} from "@/utils/myaxios";
import {numFilter} from "@/filters/myfilter";

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
      hotData: {
        hotRate:0,
        hotCountBidMoney:0,
        hotCountUser:0
      }
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
  },
  mounted() {
    myajax({
      url: "/hot",
      method: "GET",
    }).then((res) => {
      if (res.data.code == 200) {
        this.hotData = res.data.data;
        this.hotData.hotRate = numFilter(this.hotData.hotRate);
      }else{
        alert(res.data.message)
      }
    })
  },
};
</script>
