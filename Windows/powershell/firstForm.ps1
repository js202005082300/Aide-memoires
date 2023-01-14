# https://learn.microsoft.com/en-us/shows/gurupowershell/gui-form-using-powershell-add-panel-label-edit-box-combo-box-list-box-checkbox-more

## Créer le Form
Add-Type -Assembly System.Windows.Forms
Write-Host "Création du Form" (Get-Date)
$form = New-Object Windows.Forms.Form
$form.FormBorderStyle = "FixedToolWindow"
$form.Text = "PowerShell Custom GUI Window"
$form.StartPosition = "CenterScreen"
$form.Width = 740 ; $form.Height = 380

## Ajouter un bouton
$buttonPanel = New-Object Windows.Forms.panel
    $buttonPanel.Size = New-Object Drawing.Size @(400, 40)
    $buttonPanel.Dock = "Bottom"
    $cancelPanel.Size = New-Object Windows.Forms.Button
        $cancelButton.Top = $buttonPanel.Height - $cancelButton.Height - 10; $cancelButton.Left = $buttonPanel.Width - $cancelButton.Width - 10
        $cancelButton.Text = "Cancel"
        $cancelButton.DialogResult = "Cancel"
        $cancelButton.Anchor = "Right"
    $okButton = New-Object Windows.Forms.Button
        $okButton.Top = $cancelButton.Top ; $okButton.Left = $cancelButton.Left - $okButton.Width - 5
        $okButton.Text = "Ok"
        $okButton.DialogResult = "Ok"
        $okButton.Anchor = "Right"
    $buttonPanel.Controls.Add($okButton)
    $buttonPanel.Controls.Add($cancelButton)
$form.Controls.Add($buttonPanel)
$form.AcceptButton = $okButton
$form.cancelButton = $cancelButton

## Show Dialog
Write-Host "Show form" (Get-Date)
$form.Activate()
$result = $form.ShowDialog()

if($result -eq "Ok")
    { Write-Host "Ok" }
else {Write-Host "Cancel"}



