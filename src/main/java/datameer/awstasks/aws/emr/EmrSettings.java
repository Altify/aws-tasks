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
package datameer.awstasks.aws.emr;

import java.util.ArrayList;
import java.util.Collection;

import awstasks.com.amazonaws.services.ec2.model.InstanceType;
import awstasks.com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig;

public class EmrSettings {

    private final String _clusterName;// = "elastic-cluster";
    private final String _accessKey;
    private String _privateKeyName;
    private final String _s3Bucket;
    private int _instanceCount;

    private String _amiVersion;
    private String _hadoopVersion;
    private String _additionalStartInfo;
    private final Collection<BootstrapActionConfig> _bootstrapActions = new ArrayList<BootstrapActionConfig>(3);
    private InstanceType _masterInstanceType = InstanceType.M1Small;
    private InstanceType _nodeInstanceType = InstanceType.M1Small;
    private String _s3LogPath = "/emr/logs";
    private String _s3JobJarBasePath = "/emr/jobjars";
    private boolean _debugEnabled = true;
    private String _subnetId;

    /**
     * Constructs settings with all must have parameter for a {@link EmrCluster} start.
     * 
     * @param clusterName
     * @param accessKey
     * @param s3Bucket
     * @param privateKeyName
     * @param instanceCount
     */
    public EmrSettings(String clusterName, String accessKey, String privateKeyName, String s3Bucket, int instanceCount) {
        _clusterName = clusterName;
        _accessKey = accessKey;
        _s3Bucket = s3Bucket;
        _privateKeyName = privateKeyName;
        _instanceCount = instanceCount;
    }

    /**
     * Constructs settings with all must have parameter for a {@link EmrCluster} connect.
     * 
     * @param clusterName
     * @param accessKey
     * @param s3Bucket
     * @param privateKeyName
     * @param instanceCount
     */
    public EmrSettings(String clusterName, String accessKey, String s3Bucket) {
        _clusterName = clusterName;
        _s3Bucket = s3Bucket;
        _accessKey = accessKey;
    }

    public String getClusterName() {
        return _clusterName;
    }

    public String getAccessKey() {
        return _accessKey;
    }

    public String getS3Bucket() {
        return _s3Bucket;
    }

    public int getInstanceCount() {
        return _instanceCount;
    }

    public void setInstanceCount(int instanceCount) {
        _instanceCount = instanceCount;
    }

    public String getPrivateKeyName() {
        return _privateKeyName;
    }

    public void setPrivateKeyName(String privateKeyName) {
        _privateKeyName = privateKeyName;
    }

    public InstanceType getMasterInstanceType() {
        return _masterInstanceType;
    }

    public void setMasterInstanceType(InstanceType masterInstanceType) {
        _masterInstanceType = masterInstanceType;
    }

    public InstanceType getNodeInstanceType() {
        return _nodeInstanceType;
    }

    public void setNodeInstanceType(InstanceType nodeInstanceType) {
        _nodeInstanceType = nodeInstanceType;
    }

    public String getS3LogPath() {
        return _s3LogPath;
    }

    public void setS3LogPath(String s3LogPath) {
        _s3LogPath = s3LogPath;
    }

    public void setS3JobJarBasePath(String s3JobJarBasePath) {
        _s3JobJarBasePath = s3JobJarBasePath;
    }

    public String getS3JobJarBasePath() {
        return _s3JobJarBasePath;
    }

    public boolean isDebugEnabled() {
        return _debugEnabled;
    }

    public void setDebugEnabled(boolean debugEnabled) {
        _debugEnabled = debugEnabled;
    }

    public String getAmiVersion() {
        return _amiVersion;
    }

    public void setAmiVersion(String amiVersion) {
        _amiVersion = amiVersion;
    }

    public String getHadoopVersion() {
        return _hadoopVersion;
    }

    public void setHadoopVersion(String hadoopVersion) {
        _hadoopVersion = hadoopVersion;
    }

    public String getAdditionalStartInfo() {
        return _additionalStartInfo;
    }

    public void setAdditionalStartInfo(String additionalStartInfo) {
        _additionalStartInfo = additionalStartInfo;
    }

    public Collection<BootstrapActionConfig> getBootstrapActions() {
        return _bootstrapActions;
    }

    public void setSubnetId(String subnetId) {
        _subnetId = subnetId;
    }

    public String getSubnetId() {
        return _subnetId;
    }

}
