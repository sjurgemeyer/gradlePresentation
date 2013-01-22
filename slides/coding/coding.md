!SLIDE[tpl=special]
# Basic Syntax
* Task Definition:

        task myTask << {
            println "Doing something"
        }

* Gradle scripts are Groovy code
<div class="tag">Tag: basicSyntax</div>


!SLIDE left 
# doFirst and doLast
* << is an alias for doLast

        task myTask {
            doLast {
                println "Doing something"
            }
        }
* doFirst and doLast can be called after the task is defined
<div class="tag">Tag: firstAndLast</div>

!SLIDE 
# Task Dependencies
    task foo(dependsOn:bar) { .. }
    foo.dependsOn(bar)
    foo.dependsOn('bar')


!SLIDE 
# the Project object
* All non-qualified properties or method calls delegate to project
* Contains convenience methods and allows you to access project configuration properties
<div class="tag">Tag: projectObject</div>

http://gradle.org/docs/current/javadoc/org/gradle/api/Project.html

!SLIDE 
# Gradle file operations
    //File Object relative to project dir
    file('path') 

    //FileCollection
    files('path', new File('/usr/')) 

    //FileTree (extends FileCollection)
    fileTree('baseDir') {
        includes '**/*.groovy', '**/*.properties'
        excludes '**/*.class','.git/**/*'
    }


!SLIDE 
# the Task object
* Accessible by task name or tasks['taskName']
* Can be (and is) extended into custom task types

http://gradle.org/docs/current/javadoc/org/gradle/api/Task.html


!SLIDE 
# Task syntax
    //Declare a task
    task myTask
    task myTask(type: Zip)

    //Configure a task
    myTask { dependsOn taskB }

    //call doLast
    myTask << { println "Done!" }

!SLIDE 
# Custom task types
    task zip(type: Zip) {
        from 'build/output'
    }

    task mydoc(type:Copy) {
        from 'src/main/doc'
        into 'build/target/doc'
    }

!SLIDE 
# Extra properties
You can add properties to the project or a task using 'ext'
    proj(':web').ext.clientVersion=2.0
    taskName.ext.targetDir='customDir'

Extra properties can be accessed within the project/task as normal properties

!SLIDE 
# Up-to-date checking    
* Specify input and output
* Gradle uses md5 sum of input and output to determine if anything has changed
<pre>
    inputs.file file
    inputs.files fileCollection
    inputs.dir dir
    outputs.file destFile
    ...
</pre>
<div class="tag">Tag: upToDate</div>

!SLIDE 
# Configuring multi project builds
    settings.gradle
    include 'projectName'
projects can be configured in main gradle file or in individual gradle files

!SLIDE 
# Using the main build.gradle
    subprojects { 
        apply plugin: 'groovy' 
        dependencies {
            groovy 'org.codehaus.groovy:groovy-all:2.0.5'
            testCompile "org.spockframework:spock-core:0.7-groovy-2.0" 
        }
        task printProjectName << {
            print project.name
        }
    }
    allprojects {
        repositories {
            mavenCentral()
        }
    }

!SLIDE smallCode 
# Configuring individual projects within main build.gradle
    project(':subProj') {
        task newTask(dependsOn:':otherSubProj:taskName') << {
            ...
        }
    }

