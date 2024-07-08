To push schema changes on deployment we need to run following command

```bash
./mvnw --batch-mode schema-registry:register
```

ON Localhost you can push your schema like that: 
```bash
./mvnw schema-registry:register
./mvnw schema-registry:validate
./mvnw schema-registry:test-compatibility
```

Multiple schema push doesn't change the version. Looks like it only increases version if schema really has changed


To generate new POJO files run 
```dockerfile
./mvnw avro:schema
```

# TODO 
How consumer can fetch schema
- POJO should be in source control