#!/bin/bash
describe "trapps api application"
  describe "GET $HEALTH_URL"
    http_result=`curl -s -o /dev/null -H 'Accept: application/json' $HEALTH_URL -w "%{http_code},%{content_type}"`
    http_code=`echo $http_result | cut -d, -f1`
    content_type=`echo $http_result | cut -d, -f2`

    it "serves a 200 response"
      assert equal $http_code 200
    end

    it "serves up json"
      assert match $content_type "application/json"
    end
  end
end