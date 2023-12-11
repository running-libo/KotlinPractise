package com.example.kotlinpractise


// JvmStatic JvmField注解使用
//用于 Java调用kotlin 属性和方法 兼容性 而产生的
//JvmField注解使用 将默认的private修改成了public访问符
//JvmStatic 将 companion object 中的 属性、方法能像kotlin一样能直接调用
class Personz {
    @JvmField
    val names = listOf("lala", "haha", "yaya")

    //这个 names转成java就是如下代码， val修饰的 names属性成了 private final ，外部调用不到，而提供了一个方法获取
    // 使用了 @JvmField注解，将该属性从private变成public，能直接获取val修饰的属性
    /**
     * public final class Personz {
     *    @NotNull
     *    private final List names = CollectionsKt.listOf(new String[]{"lala", "haha", "yaya"});
     *
     *    @NotNull
     *    public final List getNames() {
     *       return this.names;
     *    }
     * }
     */

    companion object {
        @JvmField
        val name : String = "lala"

        @JvmStatic
        fun printlnPersonName() = println("名字： " + name)
    }
}