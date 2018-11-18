package org.hyperonline.autoviewer;

import java.util.List;
import java.util.Map;

import org.hyperonline.autoviewer.widget.AutonomousInfoWidget;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import edu.wpi.first.shuffleboard.api.data.DataType;
import edu.wpi.first.shuffleboard.api.plugin.Description;
import edu.wpi.first.shuffleboard.api.plugin.Plugin;
import edu.wpi.first.shuffleboard.api.plugin.Requires;
import edu.wpi.first.shuffleboard.api.widget.ComponentType;
import edu.wpi.first.shuffleboard.api.widget.WidgetType;

@Description(group = BuildConfig.GROUP,
    name = BuildConfig.NAME,
    version = BuildConfig.VERSION, 
    summary = "Select autonomous modes and set preferences"
)
@Requires(group = "edu.wpi.first.shuffleboard", name = "NetworkTables", minVersion = "2.0.0")
public class AutoViewerPlugin extends Plugin {
    @SuppressWarnings("rawtypes")
    @Override
    public List<DataType> getDataTypes() {
        return ImmutableList.of(
                AutonomousInfoType.Instance);
    }
    
    
    @SuppressWarnings("rawtypes")
    @Override
    public List<ComponentType> getComponents() {
        return ImmutableList.of(
                WidgetType.forAnnotatedWidget(AutonomousInfoWidget.class));
    }
    
    @SuppressWarnings("rawtypes")
    @Override
    public Map<DataType, ComponentType> getDefaultComponents() {
        return ImmutableMap.<DataType, ComponentType>builder()
                .put(AutonomousInfoType.Instance, WidgetType.forAnnotatedWidget(AutonomousInfoWidget.class))
                .build();
    }
}
