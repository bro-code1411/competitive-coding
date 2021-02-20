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

