package com.cherryleafroad.rust.playground.listeners

import com.cherryleafroad.rust.playground.Helpers
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import org.rust.cargo.project.settings.toolchain
import org.rust.cargo.runconfig.hasCargoProject

internal class ProjectManagerListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        // ignore if toolchain missing or non-Rust project; missing toolchain happens in unconfigurated projects
        if (project.toolchain != null && project.hasCargoProject) {
            Helpers.checkAndNotifyCargoPlayInstallation(project)
        }
    }
}
