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
            comboBoxMarca.Items.Add("LG");
            comboBoxMarca.Items.Add("Sony");
            comboBoxMarca.Items.Add("Huawei");
            comboBoxMarca.Items.Add("Motorola");
            comboBoxMarca.Items.Add("Apple");
            comboBoxMarca.Items.Add("One Plus");
            comboBoxMarca.Items.Add("Lenovo");
            comboBoxMarca.Items.Add("Xiaomi");
        }

        private void BotonBuscar_Click(object sender, EventArgs e)
        {

        }
    }
}
