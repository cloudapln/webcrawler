# webcrawler

Simple WebCrawler to Get SiteMap

## USAGE

* Run using maven 

    * clone project from GIT
    * cd to project dir
    * run command ``` mvn clean test ```
              

    com.example.WebCrawlerAppTest should crawl given url and generates the sitemap.

* Other way to run crawler

    Execute run com.example.WebCrawlerApplication main class in any IDE 
    
## Trade Offs
    
   Crawler is set to crawl 300 url to balance performance
   
## Imrovements

   Use parallel processing for crawling urls, that will expediate crawling process and improve performance
