regdom4j - Detect registered domain library for Java
====================================================

regdom4j is registerd domain detector for Java.
This library using [public suffix list](http://publicsuffix.org/).
Original implementation is [reg-dom-libs](http://www.dkim-reputation.org/regdom-libs/).

## Download
* Binary Download
    https://github.com/downloads/hamano/regdom4j/regdom4j-1.0.1.jar

## Command Line Usage

    $ java -jar regdom4j.jar www.sub.example.com
    > example.com
    
    $ java -jar regdom4j.jar www.sub.example.co.jp
    > example.co.jp
    
    $ java -jar regdom4j.jar www.sub.example.shinagawa.tokyo.jp
    > example.shinagawa.tokyo.jp

## Library Usage

    import jp.co.osstech.regdom4j.RegDomain;
    ...
    RegDomain regdom = new RegDomain();
    String result = regdom.getRegisteredDomain("www.example.com");

### Return Values
1) null if argument is a effective TLD
2) The registered domain name if effective TLD is known

## Generating Effective TLD Database
    $ wget -O effective_tld_names.dat "http://mxr.mozilla.org/mozilla-central/source/netwerk/dns/effective_tld_names.dat?raw=1"
    $ java -cp regdom4j.jar jp.co.osstech.regdom4j.GenerateEffectiveTLDs effective_tld_names.dat > src/main/resources/effectiveTLDs.xml

## Auther
HAMANO Tsukasa <hamano@osstech.co.jp>

## License
Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0
