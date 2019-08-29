package spinal.lib.blackbox.xilinx.s7
import spinal.core._

case class OSERDESE2(DATA_RATE_OQ : String = "DDR",
                     DATA_RATE_TQ : String = "DDR",
                     DATA_WIDTH : Int = 4,
                     SERDES_MODE : String = "MASTER",
                     TRISTATE_WIDTH : Int = 4
                     ) extends BlackBox {


  addGeneric("DATA_RATE_OQ", DATA_RATE_OQ )
  addGeneric("DATA_RATE_TQ", DATA_RATE_TQ )
  addGeneric("DATA_WIDTH", DATA_WIDTH )
  addGeneric("SERDES_MODE", SERDES_MODE )
  addGeneric("TRISTATE_WIDTH", TRISTATE_WIDTH )
  val CLK = in Bool()
  val CLKDIV = in Bool()
  val D1 = in Bool()
  val D2 = in.Bool()
  val D3 = in.Bool()
  val D4 = in.Bool()
  val D5 = in.Bool()
  val D6 = in.Bool()
  val D7 = in.Bool()
  val D8 = in.Bool()
  val T1 = in Bool()
  val T2 = in.Bool()
  val T3 = in.Bool()
  val T4 = in.Bool()
  val TCE = in Bool()
  val OCE = in Bool()
  val TBYTEIN = in Bool()  default(False)
  val RST = in Bool()
  val SHIFTIN1 = in Bool() default(False)
  val SHIFTIN2 = in Bool()  default(False)
  val OQ = out Bool()
  val OFB = out Bool()
  val TQ = out Bool()
  val TFB = out Bool()
  val TBYTEOUT = out Bool()
  val SHIFTOUT1 = out Bool()
  val SHIFTOUT2 = out Bool()

  def D(i : Int) = i match {
    case 0 => D1
    case 1 => D2
    case 2 => D3
    case 3 => D4
    case 4 => D5
    case 5 => D6
    case 6 => D7
    case 7 => D8
  }

  def T(i : Int) = i match {
    case 0 => T1
    case 1 => T2
    case 2 => T3
    case 3 => T4
  }
}



case class ODELAYE2(ODELAY_TYPE : String = "FIXED",
                    ODELAY_VALUE : Int = 0,
                    HIGH_PERFORMANCE_MODE : Boolean = false,
                    SIGNAL_PATTERN : String = "DATA",
                    REFCLK_FREQUENCY : Double = 200,
                    CINVCTRL_SEL : Boolean = false,
                    PIPE_SEL : Boolean = false,
                    DELAY_SRC : String = "ODATAIN") extends BlackBox{

  addGeneric("ODELAY_TYPE", ODELAY_TYPE)
  addGeneric("ODELAY_VALUE", ODELAY_VALUE)
  addGeneric("HIGH_PERFORMANCE_MODE", if(HIGH_PERFORMANCE_MODE) "TRUE" else "FALSE")
  addGeneric("SIGNAL_PATTERN", SIGNAL_PATTERN)
  addGeneric("REFCLK_FREQUENCY", REFCLK_FREQUENCY)
  addGeneric("CINVCTRL_SEL", if(CINVCTRL_SEL) "TRUE" else "FALSE")
  addGeneric("PIPE_SEL", if(PIPE_SEL) "TRUE" else "FALSE")
  addGeneric("DELAY_SRC", DELAY_SRC)


  val C = in Bool()
  val REGRST = in Bool()
  val LD = in Bool()
  val CE = in Bool()
  val INC = in Bool()
  val CINVCTRL = in Bool()
  val CLKIN = in Bool()
  val ODATAIN = in Bool()
  val LDPIPEEN = in Bool()
  val CNTVALUEOUT = in Bits(5 bits)
  val CNTVALUEIN = out Bits(5 bits)
  val DATAOUT = out Bool()
}


case class OBUFDS() extends BlackBox{
  val I = in Bool()
  val O, OB = out Bool()
}

case class IOBUFDS() extends BlackBox{
  val I, T = in Bool()
  val O, IO, IOB = out Bool()
}