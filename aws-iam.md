
IAM is for handling authorization not authentication

Authorization policies are generally defined within JSON documents

### Definitions 

- Resource-based policies are permissions policies that you attach to a resource such as an Amazon S3 bucket.
- Identity-based policies control what actions that identity can perform, on which resources, and under what conditions. 
  Identity-based policies can be further categorized


### Key Concepts

AWS way or handling permissions to various resources within an account. Very similar to how a JWT token has claims for a specific API. 

- Policy
  - Identity based (IAM User)
  - Resource based (Dynamo)
  
### Notes

- There is a repository of roles in an aws account that can be re-used and accessed by its name (terraform script)


### Questions

The relationship between different policy types is unclear. Sometimes it seems like 1 -> many other times it seems like it's 1 -> 1

There are quite a few different policy types 

It seems like a resource based policy is attached to another resource which grants access to something else. 
 - Example: I have a dynamoDB and an API. The api wants to access dyanmo. 
 I would apply a resource based policy to the API and it would now have access to dynamo. I don't need to whitelist the API in dynamoDB. 

You can attach a resource based policy to an Identity policy or IAM? 
