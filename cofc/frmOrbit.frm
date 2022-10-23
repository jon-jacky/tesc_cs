VERSION 5.00
Begin VB.Form frmOrbit 
   Caption         =   "Orbit"
   ClientHeight    =   8475
   ClientLeft      =   60
   ClientTop       =   345
   ClientWidth     =   8520
   LinkTopic       =   "Form1"
   ScaleHeight     =   8475
   ScaleWidth      =   8520
   StartUpPosition =   3  'Windows Default
   Begin VB.Timer clkTimer 
      Enabled         =   0   'False
      Interval        =   50
      Left            =   120
      Top             =   1560
   End
   Begin VB.CommandButton cmdStart 
      Caption         =   "Start"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   13.5
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   720
      TabIndex        =   4
      Top             =   1560
      Width           =   1215
   End
   Begin VB.TextBox txtV 
      Alignment       =   1  'Right Justify
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   720
      TabIndex        =   3
      Text            =   "600"
      Top             =   840
      Width           =   1215
   End
   Begin VB.TextBox txtG 
      Alignment       =   1  'Right Justify
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   720
      TabIndex        =   0
      Text            =   "500"
      Top             =   120
      Width           =   1215
   End
   Begin VB.Shape shpSatellite 
      FillColor       =   &H00FFFFFF&
      FillStyle       =   0  'Solid
      Height          =   255
      Left            =   4080
      Shape           =   3  'Circle
      Top             =   240
      Width           =   255
   End
   Begin VB.Label lblV 
      Alignment       =   1  'Right Justify
      Caption         =   "V"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   120
      TabIndex        =   2
      Top             =   840
      Width           =   375
   End
   Begin VB.Label lblG 
      Alignment       =   1  'Right Justify
      Caption         =   "G"
      BeginProperty Font 
         Name            =   "MS Sans Serif"
         Size            =   18
         Charset         =   0
         Weight          =   700
         Underline       =   0   'False
         Italic          =   0   'False
         Strikethrough   =   0   'False
      EndProperty
      Height          =   495
      Left            =   120
      TabIndex        =   1
      Top             =   120
      Width           =   375
   End
   Begin VB.Shape shpPlanet 
      FillColor       =   &H00FFFF00&
      FillStyle       =   0  'Solid
      Height          =   375
      Left            =   4080
      Shape           =   3  'Circle
      Top             =   4080
      Width           =   375
   End
End
Attribute VB_Name = "frmOrbit"
Attribute VB_GlobalNameSpace = False
Attribute VB_Creatable = False
Attribute VB_PredeclaredId = True
Attribute VB_Exposed = False
' Orbit - orbital physics simulation with coordinate geometry
'
'  9-May-2000  J. Jacky  Written

Option Explicit ' variable declarations required

' Constants
Dim xo As Double ' x origin, center of planet x coord
Dim yo As Double ' y origin, center of planet y coord
Dim xi As Double ' x coord of satellite initially
Dim yi As Double ' y coord of satellite initially
Dim ri As Double ' radius of satellite from planet initially
Dim w As Double ' half-width of satellite
Dim h As Double ' half-height of satellite

' Parameters
' G is gravitational constant
' adjust so it takes about 10 seconds for satellite to drop
Dim G As Double
' V is initial velocity of satellite in x direction
Dim V As Double
' time interval in one tick
Dim dt As Double

' Variables
Dim x As Double ' x coord of satellite, relative to planet
Dim y As Double ' y coord of satellite, relative to planet
Dim r As Double ' radius of satellite from origin in planet
Dim fr As Double ' radial force
Dim fx As Double ' force in x direction
Dim fy As Double ' force in y direction
Dim vx As Double ' velocity in x direction
Dim vy As Double ' velocity in y direction

' Do one integration step and update display
Private Sub Update()
    r = Sqr(x ^ 2 + y ^ 2) ' sqr is VB square root
    If r > 2 * w Then ' check for collision with planet
        fr = G * ri ^ 2 / r ^ 2 ' inverse square, normalize to initial radius
        fx = -fr * x / r ' minus sign - force pulls toward origin
        fy = -fr * y / r
        vx = vx + fx * dt ' first integration, force to velocity
        vy = vy + fy * dt ' acceleration is proportional to force
        x = x + vx * dt ' second integration, velocity to distance
        y = y + vy * dt ' distance is proportional to velocity
    Else ' collision
        vx = 0
        vy = 0
        x = 0
        y = 0
    End If
    
    ' Update
    shpSatellite.Left = x + xo - w
    shpSatellite.Top = y + yo - h
    
    ' Write out progress message
    Debug.Print "r "; Format(r, "#####"); "  fr "; Format(fr, "#####.#"); _
        "  fx "; Format(fx, "#####.#"); "  fy "; Format(fy, "#####.#"); _
        "  vx "; Format(vx, "#####.#"); "  vy "; Format(vy, "#####.#"); _
        "  x "; Format(x, "#####"); "  y "; Format(y, "#####"); _
        "  Left "; Format(shpSatellite.Left, "#####"); _
        "  Top "; Format(shpSatellite.Top, "#####")
End Sub

Private Sub clkTimer_Timer()
    Update
End Sub

' Initialize constants from properties set at design time
Private Sub Form_Load()
    ' Typical shpPlanet Left, Top = 4080 and Width, Height = 375
    ' makes xo, yo = 4268
    xo = shpPlanet.Left + shpPlanet.Width / 2
    yo = shpPlanet.Top + shpPlanet.Height / 2
    
    ' Typical shpSatellite Left = 4080, Top = 240
    w = shpSatellite.Width / 2
    h = shpSatellite.Height / 2
    xi = shpSatellite.Left + w
    yi = shpSatellite.Top + h
    ri = Sqr((xi - xo) ^ 2 + (yi - yo) ^ 2) ' sqr is VB sqrt
    
    ' Time per integration step
    dt = 0.1
End Sub
Private Sub cmdStart_Click()
    ' Initialize parameters
    G = txtG.Text
    V = txtV.Text

    ' Initial position and velocity
    x = xi - xo
    y = yi - yo
    vx = V
    vy = 0
    
    ' Make some space to separate this run
    Debug.Print
    Debug.Print
    
    ' Print intial values
    Debug.Print " xo "; Format(xo, "#####"); "  yo "; Format(yo, "#####"); _
        "  xi "; Format(xi, "#####"); "  yi "; Format(yi, "#####");
    
    ' Begin simulation
    clkTimer.Enabled = True
End Sub
Private Sub txtG_Change()
    G = txtG.Text
End Sub
Private Sub txtV_Change()
    V = txtV.Text
End Sub
