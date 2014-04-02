(: XQuery Aggregate Query :)
(: Find the highest max temperature.                                            :)
fn:max(
    let $collection := "/Users/prestoncarman/Documents/smartsvn/vxquery_git_master/vxquery-xtest/tests/TestSources/ghcnd/"
    for $r in collection($collection)/dataCollection/data
    where $r/dataType eq "TMAX" 
    return $r/value
)