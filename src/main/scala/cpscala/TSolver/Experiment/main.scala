package cpscala.TSolver.Experiment

import cpscala.TSolver.CpUtil.Constants
import cpscala.TSolver.Model.Solver.DSPSolver._
import cpscala.TSolver.Model.Solver.IPSolver._
import cpscala.TSolver.Model.Solver.SSolver._
import cpscala.XModel.XModel

object main {
  def main(args: Array[String]): Unit = {


    val path = args(0)
    val fmt = args(1).toInt
    println(path)
    val xm = new XModel(path, true, fmt)

    var i = 0
    var parallelism = 2
    var node = 0L
    var time = 0L
    var branchTime = 0L
    var propTime = 0L
    var otherTime = 0L
    var updateTableTime = 0L
    var filterDomainTime = 0L
    var backTime = 0L
    var pType = " "
    var ppType = " "
    var varType = ""
    var exe = 4
    var c_sum = 0L
    var p_sum = 0L
    val maxPara = 6

    //    pType = "STR2"
    //    varType = "SparseSet"
    //    for (i <- 1 to exe) {
    //      println(s"${i}time ${pType} ===============>")
    //      val str2 = new SCoarseSolver(xm, pType, varType, "")
    //      str2.search(Constants.TIME)
    //      node = str2.helper.nodes
    //      time += str2.helper.time
    //      c_sum = str2.helper.c_sum
    //    }
    //    println("node = " + node)
    //    println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //    println("c_sum = " + c_sum)

    time = 0L
    branchTime = 0L
    backTime = 0L
    propTime = 0L
    pType = "CT_Bit"
    varType = "BitSet"
    println(s"${pType} ===============>")
    i = 0
    while (i < exe) {
      val ct = new SCoarseSolver(xm, pType, varType, "")
      ct.search(Constants.TIME)
      node = ct.helper.nodes
      time += ct.helper.time
      branchTime += ct.helper.branchTime
      propTime += ct.helper.propTime
      backTime += ct.helper.backTime
      c_sum = ct.helper.c_sum
      p_sum = ct.helper.p_sum
      i += 1
    }
    println("node = " + node)
    println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    println("c_sum = " + c_sum)
    println("p_sum = " + p_sum)

    //    time = 0L
    //    branchTime = 0L
    //    backTime = 0L
    //    propTime = 0L
    //    pType = "CT_SSet"
    //    varType = "SparseSet"
    //    println(s"${pType} ===============>")
    //    for (i <- 1 to exe) {
    //      val ct = new SCoarseSolver(xm, pType, varType, "")
    //      ct.search(Constants.TIME)
    //      node = ct.helper.nodes
    //      time += ct.helper.time
    //      branchTime += ct.helper.branchTime
    //      propTime += ct.helper.propTime
    //      backTime += ct.helper.backTime
    //      c_sum = ct.helper.c_sum
    //    }
    //    println("node = " + node)
    //    println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //    println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //    println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //    println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //    println("c_sum = " + c_sum)
    //
    //    time = 0L
    //    branchTime = 0L
    //    propTime = 0L
    //    updateTableTime = 0L
    //    filterDomainTime = 0L
    //    backTime = 0L
    //
    //    pType = "STRbit_SSet"
    //    varType = "SparseSet"
    //    println(s"${pType} ===============>")
    //    i = 2
    //    while (i < exe) {
    //      val strbit = new SFineSolver(xm, pType, varType, "")
    //      strbit.search(Constants.TIME)
    //      node = strbit.helper.nodes
    //      time += strbit.helper.time
    //      branchTime += strbit.helper.branchTime
    //      propTime += strbit.helper.propTime
    //      //      updateTableTime += strbit.helper.updateTableTime
    //      //      filterDomainTime += strbit.helper.filterDomainTime
    //      backTime += strbit.helper.backTime
    //      c_sum = strbit.helper.c_sum
    //      i += 1
    //    }
    //    println("node = " + node)
    //    println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //    println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //    println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //    //    println("updateTable time = " + (updateTableTime / exe).toDouble * 1e-9 + "s")
    //    //    println("filterDomain time = " + (filterDomainTime / exe).toDouble * 1e-9 + "s")
    //    println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //    println("c_sum = " + c_sum)

    //    time = 0L
    //    branchTime = 0L
    //    propTime = 0L
    //    updateTableTime = 0L
    //    filterDomainTime = 0L
    //    backTime = 0L
    //
    //    pType = "STRbit_Bit"
    //    varType = "BitSet"
    //    println(s"${pType} ===============>")
    //    for (i <- 1 to exe) {
    //      val strbit = new SFineSolver(xm, pType, varType, "")
    //      strbit.search(Constants.TIME)
    //      node = strbit.helper.nodes
    //      time += strbit.helper.time
    //      branchTime += strbit.helper.branchTime
    //      propTime += strbit.helper.propTime
    //      //      updateTableTime += strbit.helper.updateTableTime
    //      //      filterDomainTime += strbit.helper.filterDomainTime
    //      backTime += strbit.helper.backTime
    //      c_sum = strbit.helper.c_sum
    //    }
    //    println("node = " + node)
    //    println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //    println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //    println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //    //    println("updateTable time = " + (updateTableTime / exe).toDouble * 1e-9 + "s")
    //    //    println("filterDomain time = " + (filterDomainTime / exe).toDouble * 1e-9 + "s")
    //    println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //    println("c_sum = " + c_sum)
    //
    //
    ppType = "IPSTRbit_SBit"
    varType = "SafeBitSet"
    parallelism = 8
    while (parallelism <= maxPara) {
      time = 0L
      branchTime = 0L
      backTime = 0L
      propTime = 0L
      println(parallelism + "线程 " + ppType + "===============>")
      for (i <- 1 to exe) {
        val pstrbit = new IPFineSolver(xm, parallelism, ppType, varType, "")
        pstrbit.search(Constants.TIME)
        pstrbit.shutdown()
        node = pstrbit.helper.nodes
        time += pstrbit.helper.time
        branchTime += pstrbit.helper.branchTime
        propTime += pstrbit.helper.propTime
        backTime += pstrbit.helper.backTime
        p_sum = pstrbit.helper.p_sum
        c_sum = pstrbit.helper.c_sum
      }
      println("node = " + node)
      println("search time = " + (time / exe).toDouble * 1e-9 + "s")
      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
      println("p_sum = " + p_sum)
      println("c_sum = " + c_sum)
      parallelism += 1
    }

    //    ppType = "IPSTRbit_SSet"
    //    varType = "SparseSet"
    //    parallelism = 2
    //    while (parallelism <= maxPara) {
    //      time = 0L
    //      branchTime = 0L
    //      backTime = 0L
    //      propTime = 0L
    //      println(parallelism + "线程 " + ppType + "===============>")
    //      for (i <- 1 to exe) {
    //        val pstrbit = new IPFineSolver(xm, parallelism, ppType, varType, "")
    //        pstrbit.search(Constants.TIME)
    //        pstrbit.shutdown()
    //        node = pstrbit.helper.nodes
    //        time += pstrbit.helper.time
    //        branchTime += pstrbit.helper.branchTime
    //        propTime += pstrbit.helper.propTime
    //        backTime += pstrbit.helper.backTime
    //        p_sum = pstrbit.helper.p_sum
    //        c_sum = pstrbit.helper.c_sum
    //      }
    //      println("node = " + node)
    //      println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //      println("p_sum = " + p_sum)
    //      println("c_sum = " + c_sum)
    //      parallelism += 1
    //    }

    ppType = "DSPSTRbit_SBit"
    varType = "SafeBitSet"
    parallelism = 8
    while (parallelism <= maxPara) {
      time = 0L
      branchTime = 0L
      backTime = 0L
      propTime = 0L
      println(parallelism + "线程 " + ppType + "===============>")
      for (i <- 1 to exe) {
        val dspStrbit = new DSPFineSolver(xm, parallelism, ppType, varType, "")
        dspStrbit.search(Constants.TIME)
        dspStrbit.shutdown()
        node = dspStrbit.helper.nodes
        time += dspStrbit.helper.time
        branchTime += dspStrbit.helper.branchTime
        propTime += dspStrbit.helper.propTime
        backTime += dspStrbit.helper.backTime
        p_sum = dspStrbit.helper.c_prop.get()
        c_sum = dspStrbit.helper.c_sub.get()
      }
      println("node = " + node)
      println("search time = " + time.toDouble * 1e-9 + "s")
      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
      println("p_sum = " + p_sum)
      println("c_sum = " + c_sum)
      parallelism += 1
    }

    //    time = 0L
    //    branchTime = 0L
    //    backTime = 0L
    //    propTime = 0L
    //
    //    pType = "STR3_SSet"
    //    varType = "SparseSet"
    //    println(s"${pType} ===============>")
    //    for (i <- 1 to exe) {
    //      val str3 = new SFineSolver(xm, pType, varType, "")
    //      str3.search(Constants.TIME)
    //      node = str3.helper.nodes
    //      time += str3.helper.time
    //      branchTime += str3.helper.branchTime
    //      propTime += str3.helper.propTime
    //      backTime += str3.helper.backTime
    //      c_sum = str3.helper.c_sum
    //    }
    //    println("node = " + node)
    //    println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //    println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //    println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //    println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //    println("c_sum = " + c_sum)

    //    time = 0L
    //    branchTime = 0L
    //    propTime = 0L
    //    updateTableTime = 0L
    //    filterDomainTime = 0L
    //    backTime = 0L
    //
    //    ppType = "IPSTR3_SBit"
    //    varType = "SafeBitSet"
    //    parallelism = 2
    //
    //    while (parallelism <= maxPara) {
    //      time = 0L
    //      branchTime = 0L
    //      backTime = 0L
    //      propTime = 0L
    //      println(parallelism + "线程 " + ppType + "===============>")
    //      for (i <- 1 to exe) {
    //        val pstr3 = new IPFineSolver(xm, parallelism, ppType, varType, "")
    //        pstr3.search(Constants.TIME)
    //        pstr3.shutdown()
    //        node = pstr3.helper.nodes
    //        time += pstr3.helper.time
    //        branchTime += pstr3.helper.branchTime
    //        propTime += pstr3.helper.propTime
    //        backTime += pstr3.helper.backTime
    //        p_sum = pstr3.helper.p_sum
    //        c_sum = pstr3.helper.c_sum
    //      }
    //      println("node = " + node)
    //      println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //      println("p_sum = " + p_sum)
    //      println("c_sum = " + c_sum)
    //      parallelism += 1
    //    }
    //
    //    ppType = "DSPSTR3_SBit"
    //    varType = "SafeBitSet"
    //    parallelism = 2
    //    while (parallelism <= maxPara) {
    //      time = 0L
    //      branchTime = 0L
    //      backTime = 0L
    //      propTime = 0L
    //      println(parallelism + "线程 " + ppType + "===============>")
    //      for (i <- 1 to exe) {
    //        val dspStr3 = new DSPFineSolver(xm, parallelism, ppType, varType, "")
    //        dspStr3.search(Constants.TIME)
    //        dspStr3.shutdown()
    //        node = dspStr3.helper.nodes
    //        time += dspStr3.helper.time
    //        branchTime += dspStr3.helper.branchTime
    //        propTime += dspStr3.helper.propTime
    //        backTime += dspStr3.helper.backTime
    //        p_sum = dspStr3.helper.c_prop.get()
    //        c_sum = dspStr3.helper.c_sub.get()
    //      }
    //      println("node = " + node)
    //      println("search time = " + time.toDouble * 1e-9 + "s")
    //      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //      println("p_sum = " + p_sum)
    //      println("c_sum = " + c_sum)
    //      parallelism += 1
    //    }

    //      ppType = "IPSTR3_SSet"
    //      varType = "SparseSet"
    //      parallelism = 2
    //
    //      while (parallelism <= maxPara) {
    //        time = 0L
    //        branchTime = 0L
    //        backTime = 0L
    //        propTime = 0L
    //        println(parallelism + "线程 " + ppType + "===============>")
    //        for (i <- 1 to exe) {
    //          val pstr3 = new IPFineSolver(xm, parallelism, ppType, varType, "")
    //          pstr3.search(Constants.TIME)
    //          pstr3.shutdown()
    //          node = pstr3.helper.nodes
    //          time += pstr3.helper.time
    //          branchTime += pstr3.helper.branchTime
    //          propTime += pstr3.helper.propTime
    //          backTime += pstr3.helper.backTime
    //          p_sum = pstr3.helper.p_sum
    //          c_sum = pstr3.helper.c_sum
    //        }
    //        println("node = " + node)
    //        println("search time = " + (time / exe).toDouble * 1e-9 + "s")
    //        println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
    //        println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
    //        println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
    //        println("p_sum = " + p_sum)
    //        println("c_sum = " + c_sum)
    //        parallelism += 2
    //      }
    //

    ppType = "IPCT_SBit"
    varType = "SafeBitSet"
    parallelism = 8
    while (parallelism <= maxPara) {
      time = 0L
      branchTime = 0L
      propTime = 0L
      otherTime = 0L
      backTime = 0L
      println(parallelism + "线程 " + ppType + "===============>")
      for (i <- 1 to exe) {
        val pct = new IPCoarseSolver(xm, parallelism, ppType, varType, "")
        pct.search(Constants.TIME)
        pct.shutdown()
        node = pct.helper.nodes
        time += pct.helper.time
        branchTime += pct.helper.branchTime
        propTime += pct.helper.propTime
        otherTime += pct.helper.lockTime
        backTime += pct.helper.backTime
        p_sum = pct.helper.p_sum
        c_sum = pct.helper.c_sum
      }
      println("node = " + node)
      println("search time = " + (time / exe).toDouble * 1e-9 + "s")
      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
      println("other time = " + (otherTime / exe).toDouble * 1e-9 + "s")
      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
      println("p_sum = " + p_sum)
      println("c_sum = " + c_sum)
      parallelism += 1
    }

    ppType = "DSPCT_SBit"
    varType = "SafeBitSet"
    parallelism = 8
    while (parallelism <= maxPara) {
      time = 0L
      branchTime = 0L
      backTime = 0L
      propTime = 0L
      println(parallelism + "线程 " + ppType + "===============>")
      for (i <- 1 to exe) {
        val pct = new DSPCoarseSolver(xm, parallelism, ppType, varType, "")
        pct.search(Constants.TIME)
        pct.shutdown()
        node = pct.helper.nodes
        time += pct.helper.time
        branchTime += pct.helper.branchTime
        propTime += pct.helper.propTime
        backTime += pct.helper.backTime
        p_sum = pct.helper.c_prop.get()
        c_sum = pct.helper.c_sub.get()
      }
      println("node = " + node)
      println("search time = " + (time / exe).toDouble * 1e-9 + "s")
      println("branch time = " + (branchTime / exe).toDouble * 1e-9 + "s")
      println("propagate time = " + (propTime / exe).toDouble * 1e-9 + "s")
      println("backtrack time = " + (backTime / exe).toDouble * 1e-9 + "s")
      println("p_sum = " + p_sum)
      println("c_sum = " + c_sum)
      parallelism += 1
    }

  }
}
