using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace IEIWindowsForms
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            comboBoxMarca.Items.Add("Samsung");
            comboBoxMarca.Items.Add("Xiaomi");
        }

        private void ComboBoxMarca_SelectedIndexChanged(object sender, EventArgs e)
        {
            comboBoxMarca.Items.Add("Samsung");
            comboBoxMarca.Items.Add("Xiaomi");
        }

        private void Button1_Click(object sender, EventArgs e)
        {

        }
    }
}
