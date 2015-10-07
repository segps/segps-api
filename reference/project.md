## Project

A Project represents an open-source project available in the Maven repository which might have direct/indirect associated NVD security vulnerabilities. 

### Properties (to be completed)
+ __id__
	The unique ID for the Project.

+ __name__
	The public name for this Project.

+ __groupID__
    The associated Maven groupId for the project.

+ __artifactID__
    The associated Maven artifactId for the project.

+ __version__
    The associated Maven version number for the project.

+ __cpeID__
    The associated NVD ID for the project.

### Making API Calls

#### Individual project
To get a single Project:
```shell
curl https://aseg.cs.concordia.ca/segps/search/project/{id}
```

To search project(s) based on criteria:
```shell
curl https://aseg.cs.concordia.ca/segps/search/project/select?q={searchQuery}
```