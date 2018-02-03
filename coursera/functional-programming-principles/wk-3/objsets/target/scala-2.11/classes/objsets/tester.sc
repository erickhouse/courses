
class Test(val hello:String = "blah", val world:String = "World")

val t = new Test()
println(t.hello)


println(t.hello + t.world)