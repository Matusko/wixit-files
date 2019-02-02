#!/bin/bash

aws cloudformation update-stack \
    --capabilities CAPABILITY_NAMED_IAM \
    --region eu-west-1 \
    --stack-name wixit-files \
    --template-body file://pipeline.yaml \
    --parameters file://pipeline-params.json
