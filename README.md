regdom4j - Detect registered domain library for Java
====================================================

regdom4j is registerd domain detector for Java.
This library using [public suffix list](http://publicsuffix.org/).
Original implementation is [reg-dom-libs](http://www.dkim-reputation.org/regdom-libs/).

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

## Javadoc
TODO :-p

## Updating Effective TLD Database
TODO :-p

## Auther
HAMANO Tsukasa <hamano@osstech.co.jp>

## License
Apache License, Version 2.0

http://www.apache.org/licenses/LICENSE-2.0
