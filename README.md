# grails-simple-marshaller

Description:
--------------
Grails plugin to customize object marshalling for JSON and XML.

Installation:
--------------
```
  plugins {
...
    compile ':simple-marshaller:0.1.5'
...
  }
```

Usage:
--------------
Annotate your classes w/ @SimpleMarshaller(includes=)

Annotate Java classes:
```
package your.annotated.java.class

import ikakara.simplemarshaller.annotation.SimpleMarshaller;

@SimpleMarshaller(includes={"strName","iNumber"})
public class Here {
  String strName;
  int iNumber;
}
```

Annotate Groovy classes:
```
package your.annotated.groovy.class

import ikakara.simplemarshaller.annotation.SimpleMarshaller;

@SimpleMarshaller(includes=["strName","iNumber"])
public class Here {
  String strName;
  int iNumber;
}
```

Manually register your classes in grails-app/conf/BootStrap.groovy
```
class BootStrap {
  def simpleMarshallerService

  def init = { servletContext ->

    // Register classes to use SimpleMarshaller annotation
    simpleMarshallerService.register(your.annotated.java.class.Here)
    simpleMarshallerService.register(your.annotated.groovy.class.Here)
...

  }
...
}
```

Or configure the classes to register in grails-app/conf/Config.groovy
```
grails {
  plugin {
    simplemarshaller {
      classes = [
        your.annotated.java.class.Here,
        your.annotated.groovy.class.Here
      ]
    }
  }
}
```

Plugin Developers can register their classes in {{Your}}GrailsPlugin.groovy
```
  import ikakara.simplemarshaller.web.app.SimpleMarshallerService

  def doWithApplicationContext = { appCtx ->

    if(appCtx) {
      def simpleMarshallerService = appCtx.getBean(SimpleMarshallerService)

      simpleMarshallerService.register(your.annotated.java.class.Here)
      simpleMarshallerService.register(your.annotated.groovy.class.Here)
    }

  }
```

Copyright & License:
--------------
Copyright 2014-2015 the original author or authors.

```
Apache 2 License - http://www.apache.org/licenses/LICENSE-2.0
```

History:
--------------
```
0.1.5 - update copyright
0.1.4 - tweak logging
0.1.3 - add logging to register
0.1.2 - fix plugin startup
0.1.1 - cleanup println
0.1   - initial checkin
```