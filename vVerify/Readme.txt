 
 Reference
 https://github.com/spring-projects/spring-boot/blob/master/spring-boot-samples/spring-boot-sample-data-jpa/src/main/java/sample/data/jpa/domain/Review.java
 
 GET PRODUCTS
 
 curl -vX GET -H "Accept: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 77c360c4-3e73-5441-1a01-0af345330755" "http://localhost:8080/product" | json_pp
Note: Unnecessary use of -X or --request, GET is already inferred.
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
  0     0    0     0    0     0      0      0 --:--:-- --:--:-- --:--:--     0*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /product HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.49.1
> Accept: application/json
> Cache-Control: no-cache
> Postman-Token: 77c360c4-3e73-5441-1a01-0af345330755
> 
< HTTP/1.1 200 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 05 Dec 2016 04:46:19 GMT
< 
{ [1781 bytes data]
100  1774    0  1774    0     0   187k      0 --:--:-- --:--:-- --:--:--  216k
* Connection #0 to host localhost left intact
[
   {
      "id" : 1,
      "title" : "Iphone 6s",
      "description" : "Excellent condition"
   },
   {
      "description" : "Excellent condition",
      "id" : 2,
      "title" : "Iphone 6s"
   },
 
 
 GET PRODUCT DETAILS
 
  curl -vX GET -H "Accept: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: 991e1a22-fb5c-2337-1f4b-d5218c24cec3" "http://localhost:8080/product/1"
Note: Unnecessary use of -X or --request, GET is already inferred.
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> GET /product/1 HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.49.1
> Accept: application/json
> Cache-Control: no-cache
> Postman-Token: 991e1a22-fb5c-2337-1f4b-d5218c24cec3
> 
< HTTP/1.1 200 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 05 Dec 2016 04:47:21 GMT
< 
* Connection #0 to host localhost left intact
{"id":1,"title":"Iphone 6s","description":"Excellent condition"}
 
 SAVE PRODUCT
 
 curl -vX POST -H "Accept: application/json" -H "Content-Type: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: a91cec8d-a730-dc2f-d028-016775fffc65" -d '{
  "title": "Iphone 6s",
  "description": "Excellent condition"
}' "http://localhost:8080/product/save"
Note: Unnecessary use of -X or --request, POST is already inferred.
*   Trying ::1...
* Connected to localhost (::1) port 8080 (#0)
> POST /product/save HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.49.1
> Accept: application/json
> Content-Type: application/json
> Cache-Control: no-cache
> Postman-Token: a91cec8d-a730-dc2f-d028-016775fffc65
> Content-Length: 66
> 
* upload completely sent off: 66 out of 66 bytes
< HTTP/1.1 201 
< Content-Type: application/json;charset=UTF-8
< Transfer-Encoding: chunked
< Date: Mon, 05 Dec 2016 04:44:50 GMT
< 
* Connection #0 to host localhost left intact
{"id":27,"title":"Iphone 6s","description":"Excellent condition"}

SAVE PRODUCT IMAGE

curl -X POST -H "Accept: application/json" -H "Cache-Control: no-cache" -H "Postman-Token: da2ebd1e-b193-75df-bead-7d19601dc32a" -H "Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW" -F "file=@thumb_IMG_3498_1024.jpg" "http://localhost:8080/product/1/uploadFile"

