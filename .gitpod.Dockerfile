FROM gitpod/workspace-mysql

RUN bash -c ". /home/gitpod/.sdkman/bin/sdkman-init.sh \
             && sdk install java 8.0.232-open"