package sparkkafka
//kafka spark streaming success
import org.apache.spark.SparkConf
import org.apache.spark.streaming.Seconds
import org.apache.spark.streaming.StreamingContext
import org.apache.spark.streaming.kafka010.KafkaUtils
import org.apache.spark.HashPartitioner
import org.apache.spark.streaming.Duration
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import scala.util.matching.Regex
import scala.util.Properties
import java.util.Properties
import java.io.FileInputStream
import sparkkafka.MySparkKafkaProducer
import org.apache.spark.broadcast.Broadcast
import org.apache.kafka.common.serialization.StringSerializer
import org.apache.kafka.common.serialization.ByteArraySerializer
import scala.util.{Try, Success, Failure}
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION
import java.util.Date
import java.text.SimpleDateFormat
import java.util.Timer
import java.util.TimerTask 
import java.util.Calendar

object simpleks {
  
       val filePath = "src/config.properties"
        val props = new Properties()
        props.load(new FileInputStream(filePath))
          //get the device
        val deviceStr=props.getProperty("device")
        var device = Array[String]()
        device=deviceStr.split(',') 
      //  device.foreach(to ⇒ println(to))
        val NUMBER = device.length
          //get the topic1 for realtime
        val topic1Str = props.getProperty("topic1")
        var topic1 = Array[String]()
        topic1 = topic1Str.split(',')
      //   topic1.foreach(to ⇒ println(to))
          //get the topic2 for workWarning
        val topic2Str = props.getProperty("topic2")
        var topic2 = Array[String]()
        topic2 = topic2Str.split(',')   
        //topic2.foreach(to ⇒ println(to))
        val outstring=new Array[String](NUMBER)
         var i = 0
         val flag3=new Array[Int](NUMBER)//flag for topic3 
         var timeold=System.currentTimeMillis()
         var timenew=System.currentTimeMillis()
        val outstringold = new Array[String](NUMBER)
        val timetwo = new Array[Long](NUMBER)
        val timethree = new Array[Long](NUMBER)
        val worktime = new Array[String](NUMBER)
        val dayliy = new Array[Int](NUMBER)
    //    var dayliysum = 0  //每日开模数
      //  var weeksum = 0    //每周开模数
        var weeksumold = 0 // 累加的每日开模
        var dailywarning = 0
        var weekwarningold=0
        for ( i <- 0 to NUMBER-1){
          outstring(i)="{"+"\"workPattern\":0,\"cycleTime\":0,\"machineCode\":\""+device(i)+"\",\"connectionStatues\":0,\"openModelMun\":0"+"}"
          outstringold(i)="{"+"\"workPattern\":0,\"cycleTime\":0,\"machineCode\":\""+device(i)+"\",\"connectionStatues\":0,\"openModelMun\":0"+"}"
        }
        for(i<- 0 to NUMBER-1){timetwo(i) =0
          timethree(i) = 0
          dayliy(i)=0
          flag3(i)=1}
        for(i<- 0 to NUMBER-1){
          worktime(i)="{"+"\"time2\":"+timetwo(i)+",\"time3\":"+timethree(i)+",\"machineCode\":\""+device(i)+"\"}"
        }
         var time0:Long=0//初始化
         var time1:Long=0
         var time2:Long=0
         var time3:Long=0
         
        
        val retopic1="ReData_MachineReal"
        val retopic2="ReData_Connections"
        val retopic3="ReData_Pattern"
        val retopic4="ReData_WorkTime"
        val retopic5="Redata_Warning"
      def timeFormat(time:String):String={
    var sdf:SimpleDateFormat = new SimpleDateFormat("HH:mm:ss")
    var date:String = sdf.format(new Date((time.toLong)))
    date
  }  
         def getNowDate():String={
    var now:Date = new Date()
    var  dateFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    var hehe = dateFormat.format( now )
    hehe
  }
         def getNowWeekStart():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
     //获取本周一的日期
    period=df.format(cal.getTime())
    period
  }
                   //纯数字字符串提取
           def strToInt(str: String): Int = {
			    val regex = """([0-9]+)""".r
			    val res = str match{
			      case regex(num) => num
			      case _ => "0"
			    }
			    val resInt = Integer.parseInt(res)
			    resInt
           	}
           //提取字符串引号内容
           def deletesome(str:String) : String={
             var res=str
             if(str.contains("\"")){ res=str.replaceAll("\"", "")}
             else{ }
             res
           }
 /*         def getNowWeekEnd():String={
    var period:String=""
    var cal:Calendar =Calendar.getInstance();
    var df:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);//这种输出的是上个星期周日的日期，因为老外把周日当成第一天
    cal.add(Calendar.WEEK_OF_YEAR, 1)// 增加一个星期，才是我们中国人的本周日的日期
    period=df.format(cal.getTime())
    period
  }
            def getYesterday():String={
    var  dateFormat:SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    var cal:Calendar=Calendar.getInstance()
    cal.add(Calendar.DATE,-1)
    var yesterday=dateFormat.format(cal.getTime())
    yesterday}
         print(getYesterday(),getNowWeekEnd())*/
		 
   //  print(timeFormat(System.currentTimeMillis().toString) )
   //每日清零
    class MyTask extends TimerTask {  
    @Override  
    def run() {  
      if(timeFormat(System.currentTimeMillis().toString)=="16:47:00"){
			        //week clean every monday 00:00:00
			         if(getNowDate() ==getNowWeekStart() ){
			           weeksumold = 0
			           weekwarningold=0}
                      else{weeksumold += dayliy.sum
                        weekwarningold+=dailywarning}
         //daily clean
        for(i<- 0 to NUMBER-1){timetwo(i) =0
          timethree(i) = 0
          dayliy(i)=0   }
      
          dailywarning=0
          time0=0//初始化
          time1=0
          time2=0
          time3=0}
      else{print(timeFormat(System.currentTimeMillis().toString))
        }
    }  
  
}
 def main(args: Array[String]) {
  
        val timer = new Timer();  
        timer.schedule(new MyTask(), 1000, 1000);  
        val sparkConf = new SparkConf().setMaster("local[2]").setAppName("kafka-spark-demo")
        val scc = new StreamingContext(sparkConf, Duration(5000))//这里设置的是5s
      
        val checkname="checkpoint_for_daysum"
        scc.checkpoint(checkname) // 因为使用到了updateStateByKey,所以必须要设置checkpoint
       
        val kafkaParams = Map[String, Object](
          "bootstrap.servers" -> "192.168.3.76:9092",
          "key.deserializer" -> classOf[StringDeserializer],
          "value.deserializer" -> classOf[StringDeserializer],
          "group.id" -> "group1",
          "auto.offset.reset" -> "latest",
          "enable.auto.commit" -> (false: java.lang.Boolean)
          )
          
            val stream1 = KafkaUtils.createDirectStream[String, String](
            scc,
            PreferConsistent,//默认
            Subscribe[String, String](topic1, kafkaParams)//realtime
           )
            val kafkaProducer: Broadcast[MySparkKafkaProducer[Array[Byte], String]] = {
				      val kafkaProducerConfig = {
				        val p = new Properties()
				        p.setProperty("bootstrap.servers", "192.168.3.76:9092")
				        p.setProperty("key.serializer", classOf[ByteArraySerializer].getName)
				        p.setProperty("value.serializer", classOf[StringSerializer].getName)
				        p
				      }
                   scc.sparkContext.broadcast(MySparkKafkaProducer[Array[Byte], String](kafkaProducerConfig))
                 }
   
           val msgstream1=stream1.map(record => (record.key, record.value)).map(_._2)
         //  val msgstream2=stream2.map(record => (record.key, record.value)).map(_._2)
           val realtime = msgstream1.map(line=>{
             val dataArr: Array[String] = line.split("\\{|\\}")
             (dataArr(0),dataArr(1))
           }).map(line=>{
//               val dataArr: Array[String] = line._2 .split(",")
	           val opennum="\"openModelMun\":"+line._2 .split(",").filter(line=>line.contains("sTotalMoldNumber"))(0).split(":")(1)
	           val workpattern="\"workPattern\":"+line._2 .split(",").filter(line=>line.contains("OP_MODE"))(0).split(":")(1)
	           val state = "\"connectionStatus\":"+line._2 .split(",").filter(line=>line.contains("State"))(0).split(":")(1)
	           val cycletime="\"cycleTime\":"+line._2 .split(",").filter(line=>line.contains("ActCylicTime"))(0).split(":")(1)
               (line._1 ,workpattern,cycletime,state,opennum)
           })
           /*val warning = msgstream2.map(line=>{
             val dataArr: Array[String] = line.split("\\{|\\}")
             (dataArr(0),dataArr(1))
           }).map(line=>{
             print("warning"+line)
             if(line._1.contains("Warning")){dailywarning+=1
               print("warning")}
             else{}
             val warningto = "{"+"\"warningnum\":"+dailywarning+",\"wwarningnum\":"+(weekwarningold+dailywarning)+"}"
             (retopic5,warningto)
           })
           warning.print*/
         
           val temp=realtime.map(line=>{
            
             timenew = System.currentTimeMillis()
             val devicetemp=line._1 .split("-|_")(4)
  
             val num = strToInt(devicetemp.substring(6).toString)
             print(num)
             val string="{"+line._2+","+line._3 +","+"\"machineCode\":\""+device(num-1)+"\","+line._4+ ","+line._5+"}"
             outstring(num-1) = string
             //retopic3 new
             val temp1 =strToInt(deletesome(line._5.split(":")(1)))
             val temp2=strToInt(deletesome(outstringold(num-1).split(",")(4).split(":|}")(1)))
             print(temp1,temp2)
             val daliysub=temp1-temp2
            if(flag3(num-1)==1){flag3(num-1)=0}
            else{
             if(daliysub > 0){
             dayliy(i)+=daliysub}
             else{}}
            val weeksum = weeksumold+dayliy.sum
             val dayliysumto="{"+"\"time1\":"+time1+",\"womnum\":"+weeksum+",\"time2\":"+time2+",\"time3\":"+time3+",\"time0\":"+time0+",\"omnum\":"+dayliy.sum+"}"
            //   print("device" +num+"  ")
             //retopic2
             var cm = 0
             for(i<- 0 to NUMBER-1){
               if(outstring(i).split(",")(3).split(":")(1) == "1"|| outstring(i).split(",")(3).split(":")(1) == "\"1\"")
                 { cm = cm+1
                 }
               else{}
             }
             val connection="{\"allm\":"+NUMBER+",\"ncm\":"+(NUMBER-cm)+",\"cm\":"+cm+"}"
             //retopic3
             val timesub = timenew - timeold
             for(i<- 0 to NUMBER -1){
               var k=strToInt(deletesome(outstringold(i).split(",")(0).split(":")(1)))
               var status = strToInt(deletesome(outstringold(i).split(",")(3).split(":")(1)))
               if(status == 1){
                k match {case 0=>time0=time0+timesub
		                case 1 =>time1 = time1 + timesub
		                case 2 =>{time2 = time2 + timesub
		                          timetwo(i)+=timesub }
		                case 3 =>{time3 = time3 + timesub
		                          timethree(i)+=timesub }              
                        }
                              }
               else {}
             }
             val pattern ="{"+ "\"time0\":"+time0+",\"time1\":"+time1+",\"time2\":"+time2+",\"time3\":"+time3+"}"
            
             //retopic4
             
             for(i<- 0 to NUMBER-1){
               if(timetwo(i)==0&&timethree(i)==0){}
               else{worktime(i)="{"+"\"time2\":"+timetwo(i)+",\"time3\":"+timethree(i)+",\"machineCode\":\""+device(i)+"\"}"}
             }
            
             outstringold(num-1) = string
             timeold = timenew
             val worktimeto = "["+worktime.filter(line=>line != null).mkString(",")+"]"
             (retopic1,"["+outstring.mkString(",")+"]",retopic2,connection,retopic3,dayliysumto,retopic4,worktimeto) 
           })
         temp.map(line=>(line._6 ,line._5 )).print
          temp.foreachRDD { rdd =>
		      rdd.foreach{ Records =>
		        
		          kafkaProducer.value.send(Records._1 ,Records._2 )
		          kafkaProducer.value.send(Records._3 ,Records._4 )
		          kafkaProducer.value.send(Records._5 ,Records._6 )
		          kafkaProducer.value.send(Records._7 ,Records._8 )
		     }
		      }
  
        scc.start() // 真正启动程序
        scc.awaitTermination() //阻塞等待
    }
}