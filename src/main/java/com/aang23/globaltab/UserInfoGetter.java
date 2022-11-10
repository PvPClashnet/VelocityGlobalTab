package com.aang23.globaltab;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;

public class UserInfoGetter {

    private final GlobalTab plugin;

    public UserInfoGetter(GlobalTab plugin) {
        this.plugin = plugin;
    }

    public String getPrefixFromUsername(String username) {
        if (plugin.server.getPluginManager().isLoaded("luckperms")) {
            User user = LuckPermsProvider.get().getUserManager().getUser(username);
            if(user != null && user.getCachedData().getMetaData().getPrefix() != null)
                return user.getCachedData().getMetaData().getPrefix();

            return getDefaultPrefix();
        }
        return "";
    }

    public String getSuffixFromUsername(String username) {
        if (plugin.server.getPluginManager().isLoaded("luckperms")) {
            User user = LuckPermsProvider.get().getUserManager().getUser(username);
            if (user != null && user.getCachedData().getMetaData().getSuffix() != null)
                return user.getCachedData().getMetaData().getSuffix();

            return getDefaultSuffix();
        }
        return "";
    }

    public String getDefaultPrefix() {
        if(plugin.server.getPluginManager().isLoaded("luckperms")) {
            Group defaultGroup = LuckPermsProvider.get().getGroupManager().getGroup("default");
            if(defaultGroup != null && defaultGroup.getCachedData().getMetaData().getPrefix() != null)
                return defaultGroup.getCachedData().getMetaData().getPrefix();
        }
        return "";
    }

    public String getDefaultSuffix() {
        if(plugin.server.getPluginManager().isLoaded("luckperms")) {
            Group defaultGroup = LuckPermsProvider.get().getGroupManager().getGroup("default");
            if(defaultGroup != null && defaultGroup.getCachedData().getMetaData().getSuffix() != null)
                return defaultGroup.getCachedData().getMetaData().getSuffix();
        }
        return "";
    }
}