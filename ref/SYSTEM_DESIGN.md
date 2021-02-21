# SYSTEM DESIGN
## Notes

- DB: ref (https://www.youtube.com/watch?v=cODCpXtPHbQ&feature=emb_logo)
- Factors
    - Structured / Non-structured data
	- Scale
	- query pattern
- Videos or photos
	- Blob storage like S3
	- CDN: used to distribute that image across the globe so that its faster to download
- Text search engine: data can be loss not should not be primary source
	- elastic search
	- Solar
	- fuzzy search
- Time series data: append writes and bulk reads
	- influx db
	- open ts db
- Analytics on data: You need a data warehouse
	- put in all the data and define query on top of it
	- snowflake

#### Scaling
Horizontal & vertical scaling \
Horizontal-scaling is often based on the partitioning of the data i.e. each node contains only part of the data. \
Vertical-scaling the data resides on a single node and scaling is done through multi-core i.e. spreading the load between the CPU and RAM resources of that machine.

#### CAP theorem
- Consistency: 
- Availability: 
- Partition tolerance:
- CA: RDBMS, SQL, MYSQL,
- CP: redis, mongodb
- AP: casandra,DynamoDB

#### System Design

- Requirements @done(21-02-19 19:44)
- Feature @done(21-02-19 19:44)
- API
- DB
    - Choice of DB @done(21-02-20 14:21)
    - schema @done(21-02-20 14:21)
    - index @done(21-02-20 14:21)
    - scale @done(21-02-20 18:48)
        - handel heavy write/reads @done(21-02-20 18:48)
        - CAP theorem @done(21-02-20 18:20)
        - horizontal vertical @done(21-02-20 18:22)
        - replica master/slave master/master @done(21-02-20 18:48)
- cache
    - What When
    - Fanout Service
- scale
    - multinode arch
- service discovery
- queues
- ELB
- Notification
- Sample Ques
    - Quora, Insta, Twitter
    - Rate Limiter
    - Cab service
    - News Aggregator

- Database Partitioning vs Sharding
- Kafka
- Spark streaming, hadoop
- consisting hashing memcache @done(21-02-20 18:48)
