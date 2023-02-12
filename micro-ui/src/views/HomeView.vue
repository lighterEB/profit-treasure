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
        <span>{{ prod.productName }}</span>
      </h2>
      <div class="new-user">
        <div class="new-user-sm">
          <span>{{ prod.bidMinLimit }}元起投</span>
          <span>投资最高限额{{ prod.bidMaxLimit }}元</span>
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
                <b>{{ prod.leftProductMoney }}</b
                >元
              </p>
              <span>利余可投资金额</span>
            </li>
          </ul>
          <a
            href="javascript:;"
            target="_blank"
            class="new-user-btn"
            @click="goLink('/details'), { productId: prod.id }"
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
        <li v-for="prod in indexData.youList" :key="prod.id">
          <h3 class="preferred-select-title">
            <span>{{ prod.productName }}</span>
            <img src="../assets/image/1-bg1.jpg" alt="" />
          </h3>
          <div class="preferred-select-number">
            <p>
              <b>{{ prod.rate }}</b
              >%
            </p>
            <span>历史年化收益率</span>
          </div>
          <div class="preferred-select-date">
            <div>
              <span>投资周期</span>
              <p>
                <b>{{ prod.cycle }}</b
                >个月
              </p>
            </div>
            <div>
              <span>余利可投资金额</span>
              <p>
                <b>{{ prod.leftProductMoney }}</b
                >元
              </p>
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
        <li v-for="prod in indexData.sanList" :key="prod.id">
          <h3 class="preferred-select-title1">
            {{ prod.name }}
            <span>散标</span>
          </h3>
          <div class="preferred-select-number">
            <p>
              <b>{{ prod.rate }}</b
              >%
            </p>
            <span>历史年化收益率</span>
          </div>
          <div class="preferred-select-date">
            <div>
              <span>投资周期</span>
              <p>
                <b>{{ prod.cycle }}</b
                >个月
              </p>
            </div>
            <div>
              <span>余利可投资金额</span>
              <p>
                <b>{{ prod.leftProductMoney }}</b
                >元
              </p>
            </div>
          </div>
          <p class="preferred-select-txt">
            优选计划项目，投资回报周期1个月，起点低，适合短期资金周转、对流动性要求高的投资人。
          </p>
          <router-link to="/details" class="preferred-select-btn"
            >立即投资</router-link
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
import {myajax} from "@/utils/myaxios";
import HeaderView from "@/views/common/HeaderView";
import FooterView from "@/views/common/FooterView";
import {numFilter} from "@/filters/myfilter"

let indexDataObject = {
  hotCountUser: 0,
  hotRate: 0,
  hotCountBidMoney: 0,
  xinList: [
  {
      id: null,
      productName: "",
      rate: 0,
      cycle: null,
      releaseTime: "",
      productType: null,
      productNo: "",
      productMoney: 0,
      leftProductMoney: 0,
      bidMinLimit: 0,
      bidMaxLimit: 0,
      productStatus: 0,
      productFullTime: 0,
      productDesc: ""
    }
  ],
  sanList: [
    {
      id: null,
      productName: "",
      rate: 0,
      cycle: null,
      releaseTime: "",
      productType: null,
      productNo: "",
      productMoney: 0,
      leftProductMoney: 0,
      bidMinLimit: 0,
      bidMaxLimit: 0,
      productStatus: 0,
      productFullTime: 0,
      productDesc: ""
    }
  ],
  youList: [
  {
      id: null,
      productName: "",
      rate: 0,
      cycle: null,
      releaseTime: "",
      productType: null,
      productNo: "",
      productMoney: 0,
      leftProductMoney: 0,
      bidMinLimit: 0,
      bidMaxLimit: 0,
      productStatus: 0,
      productFullTime: 0,
      productDesc: ""
    }
  ],
};

export default {
  name: "HomeView",
  components: {
    HeaderView,
    FooterView,
  },
  data() {
    return {
      indexData: indexDataObject,
    };
  },
  methods: {
    Product: function(){
      myajax({
      url: "/indexProduct",
      method: "GET",
    }).then((res) => {
      if(res.data.code == 200) {
          this.indexData.xinList = res.data.data.newbie.content
          this.indexData.youList = res.data.data.preferred.content
          this.indexData.sanList = res.data.data.bulk.content
      }else{
        alert(res.data.message)
      }
    })
    }
  },
  mounted() {
    myajax({
      url: "/hot",
      method: "GET",
    }).then((res) => {
      if (res.data.code == 200) {
        this.indexData.hotCountUser = res.data.data.hotCountUser;
        this.indexData.hotRate = numFilter(res.data.data.hotRate);
        this.indexData.hotCountBidMoney = res.data.data.hotCountBidMoney;
      }else{
        alert(res.data.message)
      }
    })
    this.Product();
  }
}
</script>

<style>
</style>