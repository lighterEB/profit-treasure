<template>
  <div>
    <HeaderView></HeaderView>
    <!--banner-->
    <div class="banner-content">
      <div class="swiper-container banner-lb">
        <div class="swiper-wrapper">
          <div class="swiper-slide">
            <a href="javascript:;">
              <img src="../assets/image/banner.jpg" alt="" />
            </a>
          </div>
          <div class="swiper-slide">
            <a href="javascript:;">
              <img src="../assets/image/banner.jpg" alt="" />
            </a>
          </div>
        </div>
      </div>
      <div class="banner-abs">
        <div class="banner-abs-box">
          <div class="banner-abs-title">动力金融网历史年化收益率</div>
          <b>{{ indexData.hotRate }}<i>%</i></b>
          <p>平台用户数</p>
          <span>{{ indexData.hotCountUser }}<i>位</i></span>
          <p class="banner-abs-border">累计成交金额</p>
          <span>{{ indexData.hotCountBidMoney }}<i>元</i></span>
        </div>
      </div>
    </div>
    <div class="banner-list">
      <ul>
        <li>
          <img src="../assets/image/banner-tag1.png" alt="" />
          <p>
            <b>实力雄厚</b>
            <span>亿级注册资本 ,千万技术投入</span>
          </p>
        </li>
        <li>
          <img src="../assets/image/banner-tag2.png" alt="" />
          <p>
            <b>风控严苛</b>
            <span>30道风控工序，60项信用审核</span>
          </p>
        </li>
        <li>
          <img src="../assets/image/banner-tag3.png" alt="" />
          <p>
            <b>投资省心</b>
            <span>资金安全风控，银行安全托管</span>
          </p>
        </li>
      </ul>
    </div>

    <!--产品-->
    <div class="content" v-for="prod in indexData.xinList" :key="prod.id">
      <h2 class="public-title">
        <span>{{ prod.name }}</span>
      </h2>
      <div class="new-user">
        <div class="new-user-sm">
          <span>{{ prod.minMoney }}元起投</span>
          <span>投资最高限额{{ prod.maxMoney }}元</span>
          <span>当日即系</span>
        </div>
        <div class="new-user-number">
          <ul>
            <li>
              <p>
                <b>{{ prod.rate }}</b
                >%
              </p>
              <span>历史年化收益率</span>
            </li>
            <li>
              <p>
                <b>{{ prod.cycle }}</b
                >个月
              </p>
              <span>投资周期</span>
            </li>
            <li>
              <p>
                <b>{{ prod.leftMoney }}</b
                >元
              </p>
              <span>利余可投资金额</span>
            </li>
          </ul>
          <a
            href="javascript:;"
            target="_blank"
            class="new-user-btn"
            @click="goLink('/product/detail'), { productId: prod.id }"
            >立即投资</a
          >
        </div>
        <span class="new-tag">新用户专享</span>
      </div>

      <h2 class="public-title">
        <span>优选产品</span>
        <a
          href="javascript:void(0)"
          target="_blank"
          class="public-title-more"
          @click="goLink('/product/list', { productType: 1 })"
          >查看更多产品>></a
        >
      </h2>
      <ul class="preferred-select clearfix">
        <li>
          <h3 class="preferred-select-title">
            <span>满月宝</span>
            <img src="../assets/image/1-bg1.jpg" alt="" />
          </h3>
          <div class="preferred-select-number">
            <p><b>4.9</b>%</p>
            <span>历史年化收益率</span>
          </div>
          <div class="preferred-select-date">
            <div>
              <span>投资周期</span>
              <p><b>1</b>个月</p>
            </div>
            <div>
              <span>余利可投资金额</span>
              <p><b>250000.0</b>元</p>
            </div>
          </div>
          <p class="preferred-select-txt">
            优选计划项目，投资回报周期1个月，起点低，适合短期资金周转、对流动性要求高的投资人。
          </p>
          <a href="javascript:;" target="_blank" class="preferred-select-btn"
            >立即投资</a
          >
        </li>
      </ul>

      <h2 class="public-title">
        <span>散标产品</span>
        <a href="list.html" target="_blank" class="public-title-more"
          >查看更多产品>></a
        >
      </h2>
      <ul class="preferred-select clearfix">
        <li>
          <h3 class="preferred-select-title1">
            个人信用消费借款
            <span>散标</span>
          </h3>
          <div class="preferred-select-number">
            <p><b>4.9</b>%</p>
            <span>历史年化收益率</span>
          </div>
          <div class="preferred-select-date">
            <div>
              <span>投资周期</span>
              <p><b>1</b>个月</p>
            </div>
            <div>
              <span>余利可投资金额</span>
              <p><b>250000.0</b>元</p>
            </div>
          </div>
          <p class="preferred-select-txt">
            优选计划项目，投资回报周期1个月，起点低，适合短期资金周转、对流动性要求高的投资人。
          </p>
          <a href="javascript:;" target="_blank" class="preferred-select-btn"
            >立即投资</a
          >
        </li>
      </ul>
    </div>

    <!--说明-->
    <div class="information-box">
      <ul>
        <li>
          <img src="../assets/image/2-icon1.png" alt="" />
          <p>优质借款</p>
          <span>严苛风控，多重审核</span>
        </li>
        <li>
          <img src="../assets/image/2-icon2.png" alt="" />
          <p>次日计息</p>
          <span>闪电成交，谁比我快</span>
        </li>
        <li>
          <img src="../assets/image/2-icon3.png" alt="" />
          <p>全年无休</p>
          <span>百万用户，一路同行</span>
        </li>
        <li>
          <img src="../assets/image/2-icon4.png" alt="" />
          <p>知心托付</p>
          <span>百万用户，一路同行</span>
        </li>
        <li>
          <img src="../assets/image/2-icon5.png" alt="" />
          <p>技术保障</p>
          <span>千万投入，专注研发</span>
        </li>
      </ul>
    </div>
    <FooterView></FooterView>
  </div>
</template>

<script>
import axios from "axios";
import HeaderView from "@/views/common/HeaderView";
import FooterView from "@/views/common/FooterView";

let indexDataObject = {
  hotCountUser: 0,
  hotRate: 0,
  hotCountBidMoney: 0,
  xinList: [
    {
      id: 0,
      name: "",
      rate: "",
      cycle: -1,
      leftMoney: 0,
      status: -1,
      type: -1,
      minMoney: 0,
      maxMoney: 0,
    },
  ],
  sanList: [
    {
      id: 0,
      name: "",
      rate: "",
      cycle: -1,
      leftMoney: 0,
      status: -1,
      type: -1,
      minMoney: 0,
      maxMoney: 0,
    },
  ],
  youList: [
    {
      id: 0,
      name: "",
      rate: "",
      cycle: -1,
      leftMoney: 0,
      status: -1,
      type: -1,
      minMoney: 0,
      maxMoney: 0,
    },
  ],
};

export default {
  name: "HomeView",
  components: {
    HeaderView: HeaderView,
    FooterView: FooterView,
  },
  data() {
    return {
      indexData: indexDataObject
    };
  },
  mounted() {
    let api =  `/hot`
    axios.get("/myApi" + api).then((res) => {
      this.indexData.hotCountUser = res.data.data.hotCountUser;
      this.indexData.hotRate = res.data.data.hotRate;
      this.indexData.hotCountBidMoney = res.data.data.hotCountBidMoney;
      //console.log(this.indexData.hotCountBidMoney)
    });
  },
};
</script>

<style>
</style>