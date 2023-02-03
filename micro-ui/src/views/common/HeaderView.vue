<template>
    <div class="public-head">
      <div class="public-head-nav">
        <div class="public-head-left">
          <h1 class="public-head-logo"><a href="javascript:;">
            <img src="@/assets/image/logo.png" alt="">
          </a></h1>
          <ul class="public-head-list">
            <li>
              <router-link to="/">主页</router-link>
            </li>
            <li class="public-head-hover">
              <a href="javascript:void(0);">我要投资</a>
              <!--二级导航-->
              <div class="two-title">
                <a href="javascript:;">优选类产品</a>
                <a href="javascript:;">散标类产品</a>
              </div>
            </li>
            <li>
              <router-link to="/center">借款人信息</router-link>
            </li>
            <li><a href="javascript:;" target="_blank">信息披露</a></li>
            <li><a href="javascript:;" target="_blank">安全计划</a></li>
          </ul>
        </div>
        <div class="public-head-right">
          <router-link to="/tologin">登录</router-link>
          <a href="register.html" target="_blank">注册</a>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'HeadView',
    props: {
  
    }
  }
  </script>