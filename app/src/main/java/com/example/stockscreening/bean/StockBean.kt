package com.example.stockscreening.bean


/**
 * 股票数据类
 */
data class StockBean(
    var securitiesExchange: String,
    var name: String,
    var code: String,
    var currentPrice: String,
    var receivedYesterday: String,
    var todayOpen: String,
    var tradingVolume: String,
    var outerDisc: String,
    var innerDisc: String,
    var buyOne: String,
    var buyOneQuantity: String,
    var buyTwo: String,
    var buyTwoQuantity: String,
    var buyThree: String,
    var buyThreeQuantity: String,
    var buyFour: String,
    var buyFourQuantity: String,
    var buyFive: String,
    var buyFiveQuantity: String,
    var sellOne: String,
    var sellOneQuantity: String,
    var sellTwo: String,
    var sellTwoQuantity: String,
    var sellThree: String,
    var sellThreeQuantity: String,
    var sellFour: String,
    var sellFourQuantity: String,
    var sellFive: String,
    var sellFiveQuantity: String,
    var transactionByTransactionRecently: String,
    var time: String,
    var upAndDown: String,
    var riseAndFall: String,
    var max: String,
    var minimum: String,
    var ptt: String,
    var tradingVolume2: String,
    var turnover: String,
    var turnoverRate: String,
    var priceEarningsRatio: String,
    var sunzw40: String?,
    var ttmMax: String,
    var ttmMinimum: String,
    var amplitude: String,
    var currentMarketValue: String,
    var totalMarketValue: String,
    var priceToBookRatio: String,
    var priceLimit: String,
    var fallingPriceLimit: String,
    var volumeRatio: String,
    var sunzw50: String?,
    var averagePrice: String,
    var pERatioDynamic: String,
    var pERatioStatic: String,
    var sunzw54: String?,
    var sunzw55: String?,
    var sunzw56: String?,

    ){
    constructor() : this(
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1",
        "-1")

    fun setParams(reflectEnum:ReflectIndexToStockBean,params:String){
        when(reflectEnum){
            ReflectIndexToStockBean.SECURITIESEXCHANGE->this.securitiesExchange=params
            ReflectIndexToStockBean.NAME->this.name=params
            ReflectIndexToStockBean.CODE->this.code=params
            ReflectIndexToStockBean.CURRENTPRICE->this.currentPrice=params
            ReflectIndexToStockBean.RECEIVEDYESTERDAY->this.receivedYesterday=params
            ReflectIndexToStockBean.TODAYOPEN->this.todayOpen=params
            ReflectIndexToStockBean.TRADINGVOLUME->this.tradingVolume=params
            ReflectIndexToStockBean.OUTERDISC->this.outerDisc=params
            ReflectIndexToStockBean.INNERDISC->this.innerDisc=params
            ReflectIndexToStockBean.BUYONE->this.buyOne=params
            ReflectIndexToStockBean.BUYONEQUANTITY->this.buyOneQuantity=params

            ReflectIndexToStockBean.BUYTWO->this.buyTwo=params
            ReflectIndexToStockBean.BUYTWOQUANTITY->this.buyTwoQuantity=params
            ReflectIndexToStockBean.BUYTHREE->this.buyThree=params
            ReflectIndexToStockBean.BUYTHREEQUANTITY->this.buyThreeQuantity=params
            ReflectIndexToStockBean.BUYFOUR->this.buyFour=params
            ReflectIndexToStockBean.BUYFOURQUANTITY->this.buyFourQuantity=params
            ReflectIndexToStockBean.BUYFIVE->this.buyFive=params
            ReflectIndexToStockBean.BUYFIVEQUANTITY->this.buyFiveQuantity=params
            ReflectIndexToStockBean.SELLONE->this.sellOne=params
            ReflectIndexToStockBean.SELLONEQUANTITY->this.sellOneQuantity=params

            ReflectIndexToStockBean.SELLTWO->this.sellTwo=params
            ReflectIndexToStockBean.SELLTWOQUANTITY->this.sellTwoQuantity=params
            ReflectIndexToStockBean.SELLTHREE->this.sellThree=params
            ReflectIndexToStockBean.SELLTHREEQUANTITY->this.sellThreeQuantity=params
            ReflectIndexToStockBean.SELLFOUR->this.sellFour=params
            ReflectIndexToStockBean.SELLFOURQUANTITY->this.sellFourQuantity=params
            ReflectIndexToStockBean.SELLFIVE->this.sellFive=params
            ReflectIndexToStockBean.SELLFIVEQUANTITY->this.sellFiveQuantity=params
            ReflectIndexToStockBean.TRANSACTIONBYTRANSACTIONRECENTLY->this.transactionByTransactionRecently=params
            ReflectIndexToStockBean.TIME->this.time=params

            ReflectIndexToStockBean.UPANDDOWN->this.upAndDown=params
            ReflectIndexToStockBean.RISEANDFALL->this.riseAndFall=params
            ReflectIndexToStockBean.MAX->this.max=params
            ReflectIndexToStockBean.MINIMUM->this.minimum=params
            ReflectIndexToStockBean.PTT->this.ptt=params
            ReflectIndexToStockBean.TRADINGVOLUME2->this.tradingVolume2=params
            ReflectIndexToStockBean.TURNOVER->this.turnover=params
            ReflectIndexToStockBean.TURNOVERRATE->this.turnoverRate=params
            ReflectIndexToStockBean.PRICEEARNINGSRATIO->this.priceEarningsRatio=params
            ReflectIndexToStockBean.SUNZW40->this.sunzw40=params

            ReflectIndexToStockBean.TTMMAX->this.ttmMax=params
            ReflectIndexToStockBean.TTMMINIMUM->this.ttmMinimum=params
            ReflectIndexToStockBean.AMPLITUDE->this.amplitude=params
            ReflectIndexToStockBean.CURRENTMARKETVALUE->this.currentMarketValue=params
            ReflectIndexToStockBean.TOTALMARKETVALUE->this.totalMarketValue=params
            ReflectIndexToStockBean.PRICETOBOOKRATIO->this.priceToBookRatio=params
            ReflectIndexToStockBean.PRICELIMIT->this.priceLimit=params
            ReflectIndexToStockBean.FALLINGPRICELIMIT->this.fallingPriceLimit=params
            ReflectIndexToStockBean.VOLUMERATIO->this.volumeRatio=params
            ReflectIndexToStockBean.SUNZW50->this.sunzw50=params

            ReflectIndexToStockBean.AVERAGEPRICE->this.averagePrice=params
            ReflectIndexToStockBean.PERATIODYNAMIC->this.pERatioDynamic=params
            ReflectIndexToStockBean.PERATIOSTATIC->this.pERatioStatic=params
            ReflectIndexToStockBean.SUNZW54->this.sunzw54=params
            ReflectIndexToStockBean.SUNZW55->this.sunzw55=params
            ReflectIndexToStockBean.SUNZW56->this.sunzw56=params
            else -> {}
        }
    }
}

/**
 * 查询条件类
 */
data class Condition(val index: String, val conditionName: String, val content: String)

//    [0] 证券所
//    [1] 名字
//    [2] 代码
//    [3] 当前价格
//    [4] 昨收
//    [5] 今开
//    [6] 成交量（手）
//    [7] 外盘
//    [8] 内盘
//    [9] 买一
//    [10] 买一量（手）
//    [11] 买二
//    [12] 买二量
//    [13] 买三
//    [14] 买三量
//    [15] 买四
//    [16] 买四量
//    [17] 买五
//    [18] 买五量
//    [19] 卖一
//    [20] 卖一量
//    [21] 卖二
//    [22] 卖二量
//    [23] 卖三
//    [24] 卖三量
//    [25] 卖四
//    [26] 卖四量
//    [27] 卖五
//    [28] 卖五量
//    [29] 最近逐笔成交
//    [30] 时间
//    [31] 涨跌
//    [32] 涨跌幅（%）
//    [33] 最高
//    [34] 最低
//    [35] 价格/成交量（手）/成交额
//    [36] 成交量（手）
//    [37] 成交额（万）
//    [38] 换手率
//    [39] 市盈率（TTM）
//    [40]
//    [41] 最高
//    [42] 最低
//    [43] 振幅
//    [44] 流通市值
//    [45] 总市值
//    [46] 市净率
//    [47] 涨停价
//    [48] 跌停价
//    [49] 量比
//    [50]
//    [51] 均价
//    [52] 市盈率（动）
//    [53] 市盈率（静）
//    [54]
//    [55]
//    [56]
enum class ReflectIndexToStockBean(val index:Int,val pramsName: String,val describe:String){
    ID(-1,"id","序号"),
    SECURITIESEXCHANGE(0,"securitiesExchange","证卷所"),
    NAME(1,"name","股票名称"),
    CODE(2,"code","股票编号"),
    CURRENTPRICE(3,"currentPrice","当前价格"),
    RECEIVEDYESTERDAY(4,"receivedYesterday","昨收"),
    TODAYOPEN(5,"todayOpen","今开"),
    TRADINGVOLUME(6,"tradingVolume","成交量（手）"),
    OUTERDISC(7,"outerDisc","外盘"),
    INNERDISC(8,"innerDisc","内盘"),
    BUYONE(9,"buyOne","买一"),
    BUYONEQUANTITY(10,"buyOneQuantity","买一量"),

    BUYTWO(11,"buyTwo","买二"),
    BUYTWOQUANTITY(12,"buyTwoQuantity","买二量"),
    BUYTHREE(13,"buyThree","买三"),
    BUYTHREEQUANTITY(14,"buyThreeQuantity","买三量"),
    BUYFOUR(15,"buyFour","买四"),
    BUYFOURQUANTITY(16,"buyFourQuantity","买四量"),
    BUYFIVE(17,"buyFive","买五"),
    BUYFIVEQUANTITY(18,"buyFiveQuantity","买五量"),
    SELLONE(19,"sellOne","卖一"),
    SELLONEQUANTITY(20,"sellOneQuantity","卖一量"),

    SELLTWO(21,"sellTwo","卖二"),
    SELLTWOQUANTITY(22,"sellTwoQuantity","卖二量"),
    SELLTHREE(23,"sellThree","卖三"),
    SELLTHREEQUANTITY(24,"sellThreeQuantity","卖三量"),
    SELLFOUR(25,"sellFour","卖四"),
    SELLFOURQUANTITY(26,"sellFourQuantity","卖四量"),
    SELLFIVE(27,"sellFive","卖五"),
    SELLFIVEQUANTITY(28,"sellFiveQuantity","卖五量"),
    TRANSACTIONBYTRANSACTIONRECENTLY(29,"transactionByTransactionRecently","最近逐笔成交"),
    TIME(30,"time","时间"),

    UPANDDOWN(31,"upAndDown","涨跌"),
    RISEANDFALL(32,"riseAndFall","涨跌幅"),
    MAX(33,"max","最高"),
    MINIMUM(34,"minimum","最低"),
    PTT(35,"ptt","价格/成交量（手）/成交额"),
    TRADINGVOLUME2(36,"tradingVolume2","成交量（手）"),
    TURNOVER(37,"turnover","成交额（万）"),
    TURNOVERRATE(38,"turnoverRate","换手率"),
    PRICEEARNINGSRATIO(39,"priceEarningsRatio","市盈率"),
    SUNZW40(40,"sunzw40","四十"),

    TTMMAX(41,"ttmMax","最高"),
    TTMMINIMUM(42,"ttmMinimum","最低"),
    AMPLITUDE(43,"amplitude","振幅"),
    CURRENTMARKETVALUE(44,"currentMarketValue","流通市值"),
    TOTALMARKETVALUE(45,"totalMarketValue","总市值"),
    PRICETOBOOKRATIO(46,"priceToBookRatio","市净率"),
    PRICELIMIT(47,"priceLimit","涨停价"),
    FALLINGPRICELIMIT(48,"fallingPriceLimit","跌停价"),
    VOLUMERATIO(49,"volumeRatio","量比"),
    SUNZW50(50,"sunzw50","五十"),

    AVERAGEPRICE(51,"averagePrice","均价"),
    PERATIODYNAMIC(52,"pERatioDynamic","市盈率（动）"),
    PERATIOSTATIC(53,"pERatioStatic","市盈率（静）"),
    SUNZW54(54,"sunzw54","五十四"),
    SUNZW55(55,"sunzw55","五十五"),
    SUNZW56(56,"sunzw56","五十六");


    companion object{
        private val indexCodeMap by lazy {
            mutableMapOf<Int, ReflectIndexToStockBean>().apply {
                for (type in ReflectIndexToStockBean.values()) {
                    this[type.index] = type
                }
            }
        }

        @JvmStatic
        fun valueOfIndex(index:Int)= indexCodeMap[index]
    }





}
