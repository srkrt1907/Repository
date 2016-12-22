using System;
using System.Collections.Generic;
using System.Drawing;
using System.Windows.Forms;

namespace Kruskal
{
    public partial class frmMain : Form
    {

        #region Member Variables

        const int _radius = 10;
        const int _halfRadius = (_radius / 2);

        Color _vertexColor = Color.Aqua;
        Color _edgeColor = Color.Red;

        IList<Vertex> _vertices;
        IList<Edge> _graph, _graphSolved;

        List<Vertex> _cluster;

        Vertex _firstVertex, _secondVertex;

        bool _solved , _clustered;

        #endregion

        public frmMain()
        {
            InitializeComponent();
            Clear();
        }

        #region Events

        private void panel1_MouseClick(object sender, MouseEventArgs e)
        {
            Point clicked = new Point(e.X - _halfRadius, e.Y - _halfRadius);
            _vertices.Add(new Vertex(_vertices.Count, clicked));
            panel1.Invalidate();   
        }

        private void panel1_Paint(object sender, PaintEventArgs e)
        {
            Graphics g = e.Graphics;    

            if (_clustered)
                findCluster(g);
            else
            {
                DrawVertices(g);
            }
            
            g.Dispose();
        }


        public void findEdge()
        {
            _graph = new List<Edge>();
            if (_vertices.Count > 1)
            {
                for (int i = 0; i < (_vertices.Count - 1); i++)
                {
                    _firstVertex = _vertices[i];
                    for (int j = (i + 1); j < (_vertices.Count); j++)
                    {

                        _secondVertex = _vertices[j];

                        int cost = (int)GetDistance(_firstVertex.Position, _secondVertex.Position);
                        if (cost == 0)
                            continue;


                        Point stringPoint = GetStringPoint(_firstVertex.Position, _secondVertex.Position);
                        _graph.Add(new Edge(_firstVertex, _secondVertex, cost, stringPoint));
                    }

                }
            }
        }

        private void btnSolve_Click(object sender, EventArgs e)
        {

            
        }

        private void btnClear_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Clear form ?", "Alert", MessageBoxButtons.YesNo, MessageBoxIcon.Exclamation);
            if (dr == DialogResult.Yes)
            {
                button2.Enabled = true;
                Graphics g = panel1.CreateGraphics();
                g.Clear(panel1.BackColor);
                Clear();
            }
        }

        #endregion

        #region Private Methods

        private void DrawString(string strText, Point pDrawPoint, Graphics g)
        {
            Font drawFont = new Font("Arial", 15);
            SolidBrush drawBrush = new SolidBrush(Color.Black);
            g.DrawString(strText, drawFont, drawBrush, pDrawPoint);
        }

        private void DrawVertices(Graphics g)
        {
            Pen p = new Pen(_vertexColor);
            Brush b = new SolidBrush(_vertexColor);
            int X = 0;
            int Y = 0;
            foreach (Vertex v in _vertices)
            {
                g.DrawEllipse(p, v.Position.X, v.Position.Y, _radius, _radius);
                g.FillEllipse(b, v.Position.X, v.Position.Y, _radius, _radius);
                DrawString("", v.Position, g);

                X += v.Position.X / _vertices.Count;
                Y += v.Position.Y / _vertices.Count;
            }

            if(_solved)
            {
                richTextBox1.Text = "ISTATISTLIK";
                richTextBox1.Text += Environment.NewLine + "Nokta Sayisi :" + _vertices.Count;
                richTextBox1.Text += Environment.NewLine + "1. Küme" + Environment.NewLine + " Nokta sayisi :" + _vertices.Count + Environment.NewLine + " orta nokta : " + X + "," + Y;

                Point _point = new Point(X, Y);
                g.DrawRectangle(p, new Rectangle(X, Y, 10, 10));
                g.FillRectangle(b, new Rectangle(X, Y, 10, 10));
                DrawString("", _point, g);
            }


        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text == "")
                return;

            int noktaSayisi = Convert.ToInt16(textBox1.Text);
            Clear();
            Random rnd = new Random();
            for (int i = 0; i < noktaSayisi; i++)
            {
                
                int x = rnd.Next(7, 525);
                int y = rnd.Next(7, 415);


                Point clicked = new Point(x - _halfRadius, y - _halfRadius);
                _vertices.Add(new Vertex(_vertices.Count, clicked));                
               
            }
            findEdge();
            panel1.Invalidate();
        }

        private double GetDistance(Point start, Point end)
        {
            return Math.Sqrt(Math.Pow(start.X - end.X, 2) + Math.Pow(start.Y - end.Y, 2));
        }

        private Point GetStringPoint(Point start, Point end)
        {
            int X = (start.X + end.X) / 2;
            int Y = (start.Y + end.Y) / 2;
            return new Point(X, Y);
        }

        private void button2_Click(object sender, EventArgs e)
        {
            
            findEdge();

            if (_vertices.Count > 2)
            {

                    button2.Enabled = false;
                    IKruskal kruskal = new Kruskal();
                    int totalCost;
                    _graphSolved = kruskal.Solve(_graph, out totalCost);

                    int kCluster = Convert.ToInt16(numericUpDown1.Value);
                    int number = (_graphSolved.Count - kCluster + 1);
                    for (int i = (_graphSolved.Count - 1); i >= number; i--)
                    {
                        _clustered = true;
                        totalCost -= _graphSolved[i].Cost;
                        //burada en uzak uznluklari kestigimiz noktalari aliyoruz.
                        if (_cluster != null)
                        {
                            Vertex v1 = _cluster.Find(item => item.Name == _graphSolved[i].V1.Name);
                            if (v1 == null)
                                _cluster.Add(_graphSolved[i].V1);

                            Vertex v2 = _cluster.Find(item => item.Name == _graphSolved[i].V2.Name);
                            if (v2 == null && v1 == null)
                                _cluster.Add(_graphSolved[i].V2);
                        }
                        else
                        {
                            _cluster = new List<Vertex>();
                            _cluster.Add(_graphSolved[i].V1);
                            _cluster.Add(_graphSolved[i].V2);
                        }
                        _graphSolved.RemoveAt(i);

                    }
                    _solved = true;
                    panel1.Invalidate();
                }
        }

        private void Clear()
        {
            _vertices = new List<Vertex>();
            _graph = new List<Edge>();
            _solved = false;
            _firstVertex = _secondVertex = null;
            _cluster = null;
            _clustered = false;
            richTextBox1.Text = "";
        }




        private void DrawVerticesCluester(Graphics g, List<Vertex> _v, Color vertexColor,int kümesayisi)
        {
            Pen p = new Pen(vertexColor);
            Brush b = new SolidBrush(vertexColor);

            int X = 0;
            int Y = 0;
            

            foreach(Vertex v in _v)
            {
                g.DrawEllipse(p, v.Position.X, v.Position.Y, _radius, _radius);
                g.FillEllipse(b, v.Position.X, v.Position.Y, _radius, _radius);
                DrawString("", v.Position, g);
                X += v.Position.X;
                Y += v.Position.Y;
            }

            X = X / _v.Count;
            Y = Y / _v.Count;


            if(_v.Count > 1)
            {
                Point _point = new Point(X, Y);
                g.DrawRectangle(p, new Rectangle(X, Y, 10, 10));
                g.FillRectangle(b, new Rectangle(X, Y, 10, 10));
                DrawString("", _point, g);
            }

            richTextBox1.Text += Environment.NewLine + kümesayisi + ". Küme" + Environment.NewLine + " Nokta sayisi :" + _v.Count + Environment.NewLine + " orta nokta : " + X + "," + Y;

        }


        private void findCluster(Graphics g)
        {

            richTextBox1.Text = "ISTATISTLIK";
            richTextBox1.Text += Environment.NewLine + "Nokta Sayisi :" + _vertices.Count;

            int kümesayisi = 1;
            Random randomGen = new Random();
            for (int j = 0; j< _cluster.Count; j++)
            {
                
                Vertex vAra = _cluster[j];
                Color randomColor = Color.FromArgb(randomGen.Next(256), randomGen.Next(256), randomGen.Next(256));

                List<Edge> subList = new List<Edge>(_graphSolved);
                List<Vertex> cluster = new List<Vertex>();
                cluster.Add(vAra);

                List<Vertex> vArananlar = new List<Vertex>();
                vArananlar.Add(vAra);

                for(int i = 0; i< vArananlar.Count;i++)
                {
                    Vertex kumelenen = vArananlar[i];

                    Console.Write("\n aranan = " + vAra.Name);

                    bool bulundu = false;
                    List<Edge> edgeSoltaraf = subList.FindAll(item => item.V1 == kumelenen);//find point on v1
                    List<Edge> edgeSagTaraf = subList.FindAll(item => item.V2 == kumelenen);//find point on v2


                    foreach (Edge sol in edgeSoltaraf)
                    {
                        Vertex temp = vArananlar.Find(item => item.Name == sol.V2.Name);
                        if(temp == null)
                        {
                            vArananlar.Add(sol.V2);
                            cluster.Add(sol.V2);
                            bulundu = true;
                            subList.Remove(sol);
                            
                        }
                        
                    }
                    foreach (Edge sag in edgeSagTaraf)
                    {
                        Vertex temp = vArananlar.Find(item => item.Name == sag.V1.Name);
                        if(temp == null)
                        {
                            vArananlar.Add(sag.V1);
                            cluster.Add(sag.V1);
                            bulundu = true;
                            subList.Remove(sag);
                        }
                    }
                    
                    if(bulundu)
                    {
                        Vertex temp = vArananlar.Find(item => item.Name == kumelenen.Name);
                        if (temp == null)
                        {
                            vArananlar.Add(kumelenen);
                        }
                    }
                }

                for(int k = (j+1); k < _cluster.Count;k++)
                {

                    Vertex temp = vArananlar.Find(item => item.Name == _cluster[k].Name);
                    if(temp != null)
                     {
                        _cluster.Remove(temp);
                     }
                }

                DrawVerticesCluester(g, cluster, randomColor, kümesayisi);
                kümesayisi++;

            }
        }
    }
        #endregion
    }
