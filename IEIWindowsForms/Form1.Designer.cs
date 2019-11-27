namespace IEIWindowsForms
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.comboBoxMarca = new System.Windows.Forms.ComboBox();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.BotonBuscar = new System.Windows.Forms.Button();
            this.checkBoxAmazon = new System.Windows.Forms.CheckBox();
            this.checkBoxFnac = new System.Windows.Forms.CheckBox();
            this.checkBoxPcComponets = new System.Windows.Forms.CheckBox();
            this.SuspendLayout();
            // 
            // comboBoxMarca
            // 
            this.comboBoxMarca.FormattingEnabled = true;
            this.comboBoxMarca.Location = new System.Drawing.Point(127, 23);
            this.comboBoxMarca.Name = "comboBoxMarca";
            this.comboBoxMarca.Size = new System.Drawing.Size(572, 21);
            this.comboBoxMarca.TabIndex = 0;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(127, 66);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(572, 20);
            this.textBox1.TabIndex = 1;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(73, 31);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(37, 13);
            this.label1.TabIndex = 2;
            this.label1.Text = "Marca";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(73, 73);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(42, 13);
            this.label2.TabIndex = 3;
            this.label2.Text = "Modelo";
            // 
            // BotonBuscar
            // 
            this.BotonBuscar.Location = new System.Drawing.Point(127, 197);
            this.BotonBuscar.Name = "BotonBuscar";
            this.BotonBuscar.Size = new System.Drawing.Size(572, 23);
            this.BotonBuscar.TabIndex = 4;
            this.BotonBuscar.Text = "Buscar";
            this.BotonBuscar.UseVisualStyleBackColor = true;
            this.BotonBuscar.Click += new System.EventHandler(this.BotonBuscar_Click);
            // 
            // checkBoxAmazon
            // 
            this.checkBoxAmazon.AutoSize = true;
            this.checkBoxAmazon.Location = new System.Drawing.Point(127, 107);
            this.checkBoxAmazon.Name = "checkBoxAmazon";
            this.checkBoxAmazon.Size = new System.Drawing.Size(64, 17);
            this.checkBoxAmazon.TabIndex = 5;
            this.checkBoxAmazon.Text = "Amazon";
            this.checkBoxAmazon.UseVisualStyleBackColor = true;
            // 
            // checkBoxFnac
            // 
            this.checkBoxFnac.AutoSize = true;
            this.checkBoxFnac.Location = new System.Drawing.Point(127, 153);
            this.checkBoxFnac.Name = "checkBoxFnac";
            this.checkBoxFnac.Size = new System.Drawing.Size(50, 17);
            this.checkBoxFnac.TabIndex = 6;
            this.checkBoxFnac.Text = "Fnac";
            this.checkBoxFnac.UseVisualStyleBackColor = true;
            // 
            // checkBoxPcComponets
            // 
            this.checkBoxPcComponets.AutoSize = true;
            this.checkBoxPcComponets.Location = new System.Drawing.Point(127, 130);
            this.checkBoxPcComponets.Name = "checkBoxPcComponets";
            this.checkBoxPcComponets.Size = new System.Drawing.Size(98, 17);
            this.checkBoxPcComponets.TabIndex = 7;
            this.checkBoxPcComponets.Text = "PcComponents";
            this.checkBoxPcComponets.UseVisualStyleBackColor = true;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(802, 262);
            this.Controls.Add(this.checkBoxPcComponets);
            this.Controls.Add(this.checkBoxFnac);
            this.Controls.Add(this.checkBoxAmazon);
            this.Controls.Add(this.BotonBuscar);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.comboBoxMarca);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ComboBox comboBoxMarca;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button BotonBuscar;
        private System.Windows.Forms.CheckBox checkBoxAmazon;
        private System.Windows.Forms.CheckBox checkBoxFnac;
        private System.Windows.Forms.CheckBox checkBoxPcComponets;
    }
}

