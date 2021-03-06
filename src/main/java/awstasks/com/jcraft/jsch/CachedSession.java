/**
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package awstasks.com.jcraft.jsch;

import awstasks.com.jcraft.jsch.JSch;
import awstasks.com.jcraft.jsch.JSchException;
import awstasks.com.jcraft.jsch.Session;
import datameer.com.google.common.base.Objects;

public class CachedSession extends Session {

    private String _credentialHash;

    public CachedSession(String user, String host, int port, String credentialHash, JSch jsch) throws JSchException {
        super(jsch, user, host, port);
        _credentialHash = credentialHash;
    }

    @Override
    public void disconnect() {
        // do nothing - prevent disconnect
    }

    public void forcedDisconnect() {
        super.disconnect();
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).addValue(sshUrl(username, _credentialHash, getHost(), getPort())).toString();
    }

    public static String sshUrl(String username, String credentialHash, String host, int port) {
        return String.format("%s:%s@%s:%s", username, credentialHash, host, port);
    }
}
