.PHONY: clean all

build:
	./gradlew :content_shell:assembleRelease

clean:
	./gradlew clean


format:
	./gradlew :content_shell:spotlessApply && ./gradlew :content_shell_demo:spotlessApply

