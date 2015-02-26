grails {
  plugin {
    simplemarshaller {
      classes = [
        ikakara.simplemarshaller.web.app.SimpleMarshallerService,
        ikakara.simplemarshaller.test.AnnotatedJavaClass,
        ikakara.simplemarshaller.test.AnnotatedGroovyClass
      ]
    }
  }
}
