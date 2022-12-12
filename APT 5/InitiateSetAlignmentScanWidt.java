public void InitiateSetAlignmentScanWidth(double alignmentScanWidth){
    if (alignmentScanWidth >= 0.0){
        ConfigurationSettings.Scan.AlignmentScanWidth = alignmentScanWidth;
    }
    else{
        ConfigurationSettings.Scan.AlignmentScanWidth = 0.0;
    }

    if ((ConfigurationSettings.Scan.YAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) > 1.0){
        InitiateSetAlignmentScanHorizontalOffset(ConfigurationSettings.Scan.YAxisOffset - ((ConfigurationSettings.Scan.YAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) - 1.0));
    }

    else if ((ConfigurationSettings.Scan.YAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) < -1.0){
        InitiateSetAlignmentScanHorizontalOffset(ConfigurationSettings.Scan.YAxisOffset - ((ConfigurationSettings.Scan.YAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) + 1.0));
    }

    if ((ConfigurationSettings.Scan.XAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) > 1.0){
        InitiateSetAlignmentScanVerticalOffset(ConfigurationSettings.Scan.XAxisOffset - ((ConfigurationSettings.Scan.XAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) - 1.0));
    }
    
    else if ((ConfigurationSettings.Scan.XAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) < -1.0){
        InitiateSetAlignmentScanVerticalOffset(ConfigurationSettings.Scan.XAxisOffset - ((ConfigurationSettings.Scan.XAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) + 1.0));
    }

    OnSettingChanged("Scan.AlignmentScanWidth");
    }

    public void InitiateSetAlignmentScanHorizontalOffset(double alignmentScanHorizontalOffset)
    {
    ConfigurationSettings.Scan.YAxisOffset = alignmentScanHorizontalOffset;

    if ((ConfigurationSettings.Scan.YAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) > 1.0)
    {
    InitiateSetAlignmentScanWidth(ConfigurationSettings.Scan.AlignmentScanWidth - ((ConfigurationSettings.Scan.YAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) - 1.0));
    }
    else if ((ConfigurationSettings.Scan.YAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) < -1.0)
    {
    InitiateSetAlignmentScanWidth(ConfigurationSettings.Scan.AlignmentScanWidth + ((ConfigurationSettings.Scan.YAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) + 1.0));
    }

    OnSettingChanged("Scan.AlignmentScanYAxisOffset");
    }

    public void InitiateSetAlignmentScanVerticalOffset(double alignmentScanVerticalOffset)
    {
    ConfigurationSettings.Scan.XAxisOffset = alignmentScanVerticalOffset;

    if ((ConfigurationSettings.Scan.XAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) > 1.0)
    {
    InitiateSetAlignmentScanWidth(ConfigurationSettings.Scan.AlignmentScanWidth - ((ConfigurationSettings.Scan.XAxisOffset + ConfigurationSettings.Scan.AlignmentScanWidth) - 1.0));
    }
    else if ((ConfigurationSettings.Scan.XAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) < -1.0)
    {
    InitiateSetAlignmentScanWidth(ConfigurationSettings.Scan.AlignmentScanWidth + ((ConfigurationSettings.Scan.XAxisOffset - ConfigurationSettings.Scan.AlignmentScanWidth) + 1.0));
    }

    OnSettingChanged("Scan.AlignmentScanXAxisOffset");
    }