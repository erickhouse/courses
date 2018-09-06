
### Resources

Highly recommended series of books 

https://www.amazon.com/gp/product/1118530802/#customerReviews

#### ETL ideas

https://medium.com/poka-techblog/serverless-etl-using-lambda-and-sqs-d8b4de1d1c43

### Keywords

- Enrich
- Transform
- Translate
- Structure
- Data Mart
- Procurement

### Problems

- Difficulty of business users to access the data


### Data sources
- CRM (Customer Relation Management)
- Google analytics 
- API (in house or 3rd party)

### Data Warehouses

- Typically structured SQL
- Rigid and difficult to change

### Data Lakes

Core concepts

- No data is turned away. It is a massive staginig area for all data that is relevant to the organization. 
- Schema on Read, meaning that strucutre is only defined when a purpose is found. It is more ad-hoc to the specific query. 
- Cheap, designed for petabytes
- Use Cases: machine learning, exploritory data analysis, data enrichment from other sources

### Implementation

- Serverless functions
- Queues
- Push vs Pull Models
  - event driven vs direct query


### Notes


