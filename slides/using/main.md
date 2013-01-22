!SLIDE title-slide
.notes first slide

# Gradle for the Uninitiated #
## Shaun Jurgemeyer ##
Principal Consultant  
Object Partners, Inc

!SLIDE 
# What is Gradle? #
* JVM based build tool
* Conventions similar to Maven
* Power of Ant
* Scripted entirely in a Groovy DSL

http://gradle.org

!SLIDE 
# Example
* Uses groovy and java plugin
* Similar conventions to maven
<div class="tag">Tag: simpleExample</div>

!SLIDE 
# Tasks and Dependencies
* Gradle tasks == Ant targets
* Tasks can be dependent on other tasks
* Gradle resolves dependency order (Configuration phase) before executing (Execution phase)
* Tasks are only executed when not up to date


!SLIDE 
# Command line
    gradle tasks
    gradle --help
    -i (--info) 
    -d (--debug)
    -m (dry run - see which tasks will be 
        executed)
    -x (exclude a task)
!SLIDE 
# Command Line (cont.)
* Multiple tasks per command
<pre> gradle clean assemble </pre>
* Commands can be abbreviated
<pre>
gradle myReallyLongTaskName
gradle mRLTN
</pre>


!SLIDE 
# Configuration
## Locations - Last one wins
*  gradle.properties - in project dir
*  gradle.properties - $HOME
*  system properties

## A few common items
    org.gradle.java.home=/my/java/home
    org.gradle.jvmargs=


!SLIDE 
# Gradle Daemon
* Daemon keeps a 'warm' JVM available and reduces the run time
<pre>
    gradle --daemon
    org.gradle.daemon=true
</pre>

!SLIDE 
# Multi project builds
* sub projects are defined in settings.gradle
* dependencies can exist between projects
* tasks for specific projects can be referenced with the syntax
<pre>projectName:taskName</pre>
* list tasks for all projects with
<pre>gradle tasks --all</pre>
<div class="tag">Tag: multiProject</div>
