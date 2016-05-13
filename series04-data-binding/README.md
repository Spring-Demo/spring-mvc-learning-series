# 绑定数据的注解
1.@RequestParam，绑定单个请求数据，可以是URL中的数据，表单提交的数据或上传的文件； 
2.@PathVariable，绑定URL模板变量值； 
3.@CookieValue，绑定Cookie数据； 
4.@RequestHeader，绑定请求头数据； 
5.@ModelAttribute，绑定数据到Model； 
6.@SessionAttributes，绑定数据到Session； 
7.@RequestBody，用来处理Content-Type不是application/x-www-form-urlencoded编码的内容，例如application/json, application/xml等； 
8.@RequestPart，绑定“multipart/data”数据，并可以根据数据类型进项对象转换；