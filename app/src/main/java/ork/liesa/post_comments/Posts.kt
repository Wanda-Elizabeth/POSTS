package ork.liesa.post_comments

 data class Posts(var userId:Int,
                 var id:Int,
                 var title:String,
                 var body:String)
 data class Comments(
    var postId:Int,
    var id:Int,
    var name:String,
    var email:String,
    var body: String)
fun <T> compareIds(item1:T,item2:T):T{
    var output=(item1.toString()+item2.toString())
    println(output)
    return item1
}

//fun  compareIds(post1: Posts, post2:Posts):Posts{
//    if (post1.id >post2.id){
//        return  post1
//    }
//   return post2
//}
//fun  compareIds(comment1: Comments, comment2:Comments):Comments{
//    if (comment1.id >comment2.id){
//        return  comment1
//    }
//    return comment2
//}

