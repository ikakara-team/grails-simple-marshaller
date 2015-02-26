import ikakara.simplemarshaller.web.app.SimpleMarshallerService

class SimpleMarshallerGrailsPlugin {
  def version = "0.1"
  def grailsVersion = "2.0 > *"
  def pluginExcludes = [
    "**/test/**"
  ]
  def title = "Simple Marshaller Plugin"
  def author = "Allen Arakaki"
  def description = 'Plugin to customize object marshalling for JSON and XML.  @SimpleMarshaller(includes=[])'
  def documentation = "http://grails.org/plugin/simple-marshaller"
  def license = "APACHE"
  def issueManagement = [url: 'https://github.com/ikakara-team/grails-simple-marshaller/issues']
  def scm = [url: 'https://github.com/ikakara-team/grails-simple-marshaller']

  def doWithApplicationContext = { appCtx ->
    def classes = application.mergedConfig.grails.plugin.simplemarshaller.classes

    println "Configuring SimpleMarshaller $classes"

    if (appCtx) {
      def simpleMarshallerService = appCtx.getBean(SimpleMarshallerService)

      classes.each {
        println "Registering ${it} ..."
        simpleMarshallerService.register(it)
        println "... finished registering ${it}"
      }
    }

    println '... finished configuring SimpleMarshaller'
  }

  def afterConfigMerge = { config, ctx ->
    // let's put the mergedConfig in ctx
    ctx.appConfig.grails.plugin.simplemarshaller.putAll(config.grails.plugin.simplemarshaller)

    ctx.grailsApplication.config.grails.plugin.simplemarshaller.each { println "SimpleMarshaller afterConfigMerge $it" }
  }
}
