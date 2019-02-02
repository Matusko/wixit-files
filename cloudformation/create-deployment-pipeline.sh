#!/bin/bash

aws cloudformation create-stack \
    --capabilities CAPABILITY_NAMED_IAM \
    --region eu-west-1 \
    --stack-name wixit-fles \
    --template-body file://pipeline.yaml \
    --parameters file://pipeline-params.json
