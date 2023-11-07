package likou

import scala.collection.mutable

/**
 * @author: BYDylan
 * @date: 2023/11/9
 * @description: 两数相加
 *               给定一个整数数组 nums和一个整数目标值 target,请你在该数组中找出 和为目标值 target 的那两个整数,并返回它们的数组下标。
 *               你可以假设每种输入只会对应一个答案。但是,数组中同一个元素在答案里不能重复出现。
 *               输入：nums = [2,7,11,15], target = 9
 *               输出：[0,1]
 *               解释：因为 nums[0] + nums[1] == 9 ,返回 [0, 1]
 */
object Solution1 {
  def main(args: Array[String]): Unit = {
    val nums: Array[Int] = Array(2, 7, 11, 15)
    println(twoSum(nums, 9).mkString(","))
  }

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    // key 存储值,value 存储下标
    val resultMap = new mutable.HashMap[Int, Int]()
    for (index <- nums.indices) {
      val temp: Int = target - nums(index)
      // 如果这个差值存在于 map,则说明找到了结果
      if (resultMap.contains(temp)) {
        return Array(resultMap.get(temp).get, index)
      }
      // 如果不包含把当前值与其下标放到map
      resultMap.put(nums(index), index)
    }
    // 如果没有找到直接返回一个空数组,return 可以省略
    Array[Int](2)
  }
}
