package com.hjc.common.util

def result='';
def _1 ='sadsf,params,sdf';
def params="${_1}".replaceAll('[\\\\[|\\\\]|\\\\s]', '').split(',').toList();
for(i = 0; i < params.size(); i++) {
    result+=' * @param: ' + params[i] + ((i < params.size() - 1) ? '\\n\\b' : '');
};
printf(result)
return result

