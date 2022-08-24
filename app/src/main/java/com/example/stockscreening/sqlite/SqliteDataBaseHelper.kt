package com.example.stockscreening.sqlite

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.stockscreening.bean.StockBean
import java.lang.reflect.Field

class SqliteDataBaseHelper(context: Context?, name: String?, version: Int) :
    SQLiteOpenHelper(context, name, null, version) {



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


    private val createTableString = "create table Stock(" +
            "id integer primary key autoincrement," +                //id
            "securitiesExchange text," +   //证券所
            "name text," +
            "code text," +
            "currentPrice text," +
            "receivedYesterday text," +
            "todayOpen text," +
            "tradingVolume text," +
            "outerDisc text," +
            "innerDisc text," +
            "buyOne text," +
            "buyOneQuantity text," +
            "buyTwo text," +
            "buyTwoQuantity text," +
            "buyThree text," +
            "buyThreeQuantity text," +
            "buyFour text," +
            "buyFourQuantity text," +
            "buyFive text," +
            "buyFiveQuantity text," +
            "sellOne text," +
            "sellOneQuantity text," +
            "sellTwo text," +
            "sellTwoQuantity text," +
            "sellThree text," +
            "sellThreeQuantity text," +
            "sellFour text," +
            "sellFourQuantity text," +
            "sellFive text," +
            "sellFiveQuantity text," +
            "transactionByTransactionRecently text," +
            "time text," +
            "upAndDown text," +
            "riseAndFall text," +
            "max text," +
            "minimum text," +
            "ptt," +
            "tradingVolume2 text," +
            "turnover  text," +
            "turnoverRate text," +
            "priceEarningsRatio text," +
            "sunzw40 text," +
            "ttmMax text," +
            "ttmMinimum text," +
            "amplitude text," +
            "currentMarketValue text," +
            "totalMarketValue text," +
            "priceToBookRatio text," +
            "priceLimit text," +
            "fallingPriceLimit text," +
            "volumeRatio text," +
            "sunzw50 text," +
            "averagePrice text," +
            "pERatioDynamic text," +
            "pERatioStatic text," +
            "sunzw54 text," +
            "sunzw55 text," +
            "sunzw56 text" +

            ")"

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(createTableString)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun add (data:StockBean){
        var values=ContentValues()
         values.put("securitiesExchange",data.securitiesExchange)
        values.put("name",data.name)
        values.put("code",data.code)
        values.put("currentPrice",data.currentPrice)
        values.put("receivedYesterday",data.receivedYesterday)
        values.put("todayOpen",data.todayOpen)
        values.put("tradingVolume",data.tradingVolume)
        values.put("outerDisc",data.outerDisc)
        values.put("innerDisc",data.innerDisc)
        values.put("buyOne",data.buyOne)
        values.put("buyOneQuantity",data.buyOneQuantity)
        values.put("buyTwo",data.buyTwo)
        values.put("buyTwoQuantity",data.buyTwoQuantity)
        values.put("buyThree",data.buyThree)
        values.put("buyThreeQuantity",data.buyThreeQuantity)
        values.put("buyFour",data.buyFour)
        values.put("buyFourQuantity",data.buyFourQuantity)
        values.put("buyFive",data.buyFive)
        values.put("buyFiveQuantity",data.buyFiveQuantity)
        values.put("sellOne",data.sellOne)
        values.put("sellOneQuantity",data.sellOneQuantity)
        values.put("sellTwo",data.sellTwo)
        values.put("sellTwoQuantity",data.sellTwoQuantity)
        values.put("sellThree",data.sellThree)
        values.put("buyThreeQuantity",data.buyThreeQuantity)
        values.put("sellFour",data.sellFour)
        values.put("sellFourQuantity",data.sellFourQuantity)
        values.put("sellFive",data.sellFive)
        values.put("sellFiveQuantity",data.sellFiveQuantity)
        values.put("transactionByTransactionRecently",data.transactionByTransactionRecently)
        values.put("time",data.time)
        values.put("upAndDown",data.upAndDown)
        values.put("riseAndFall",data.riseAndFall)
        values.put("max",data.max)
        values.put("minimum",data.minimum)
        values.put("ptt",data.ptt)
        values.put("tradingVolume2",data.tradingVolume2)
        values.put("turnover",data.turnover)
        values.put("turnoverRate",data.turnoverRate)
        values.put("priceEarningsRatio",data.priceEarningsRatio)
        values.put("sunzw40",data.sunzw40)
        values.put("ttmMax",data.ttmMax)
        values.put("ttmMinimum",data.ttmMinimum)
        values.put("amplitude",data.amplitude)
        values.put("currentMarketValue",data.currentMarketValue)
        values.put("totalMarketValue",data.totalMarketValue)
        values.put("ttmMinimum",data.priceToBookRatio)
        values.put("fallingPriceLimit",data.fallingPriceLimit)
        values.put("volumeRatio",data.volumeRatio)
        values.put("sunzw50",data.sunzw50)
        values.put("averagePrice",data.averagePrice)
        values.put("pERatioDynamic",data.pERatioDynamic)
        values.put("pERatioStatic",data.pERatioStatic)
        values.put("sunzw54",data.sunzw54)
        values.put("sunzw55",data.sunzw55)
        values.put("sunzw56",data.sunzw56)
        val db=this.writableDatabase
          db.insert("Stock",null,values)
    }

    @SuppressLint("Range")
    fun find():MutableList<StockBean>{
        var array= mutableListOf<StockBean>()
         val db=this.writableDatabase
         val cursor=db.query("Stock",null,null,null,null,null,null)
         if(cursor.moveToFirst()){
             do{
                 val stockBean=StockBean()
                 stockBean.name=cursor.getString(cursor.getColumnIndex("name"))
                 stockBean.volumeRatio=cursor.getString(cursor.getColumnIndex("volumeRatio"))
                 stockBean.upAndDown=cursor.getString(cursor.getColumnIndex("upAndDown"))
                 stockBean.riseAndFall=cursor.getString(cursor.getColumnIndex("riseAndFall"))
                 stockBean.turnoverRate=cursor.getString(cursor.getColumnIndex("turnoverRate"))
                 stockBean.currentMarketValue=cursor.getString(cursor.getColumnIndex("currentMarketValue"))
                 array.add(stockBean)
             }while (cursor.moveToNext())

         }
        cursor.close()
        return array
    }

    fun clear(){
        val db=this.writableDatabase
        db.delete("Stock",null,null)
    }



}