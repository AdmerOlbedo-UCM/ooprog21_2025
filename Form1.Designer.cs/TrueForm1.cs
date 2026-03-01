using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        // exchange rates defined as USD value per 1 unit of currency (USD per unit)
        // Set PHP so that 20000 PHP -> 364.25 USD: 364.25 / 20000 = 0.0182125 USD per PHP
        private readonly Dictionary<string, double> rates = new Dictionary<string, double>(StringComparer.OrdinalIgnoreCase)
        {
            { "PHP", 0.0182125 },
            { "EUR", 1.10 },
            { "CAD", 0.75 },
            { "USD", 1.0 }
        };

        public Form1()
        {
            InitializeComponent();

            // set defaults
            // default to PHP -> USD for testing
            int idxFrom = comboFrom.Items.IndexOf("PHP");
            if (idxFrom >= 0) comboFrom.SelectedIndex = idxFrom; else if (comboFrom.Items.Count > 0) comboFrom.SelectedIndex = 0;
            int idxTo = comboTo.Items.IndexOf("USD");
            if (idxTo >= 0) comboTo.SelectedIndex = idxTo; else if (comboTo.Items.Count > 1) comboTo.SelectedIndex = 1;

            this.AcceptButton = btnConvert;
        }

        private void btnConvert_Click(object sender, EventArgs e)
        {
            string from = comboFrom.SelectedItem as string;
            string to = comboTo.SelectedItem as string;

            if (string.IsNullOrEmpty(from) || string.IsNullOrEmpty(to))
            {
                MessageBox.Show("Please select both currencies.", "Validation", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (!double.TryParse(txtAmount.Text, out double amount))
            {
                MessageBox.Show("Please enter a valid numeric amount.", "Validation", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            if (!rates.ContainsKey(from) || !rates.ContainsKey(to))
            {
                MessageBox.Show("Selected currency is not supported.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // convert: amount_in_usd = amount * rates[from]
            double amountInUsd = amount * rates[from];
            double converted = amountInUsd / rates[to];

            // show converted amount using target currency only (no source currency shown)
            string symbol = GetCurrencySymbol(to);
            lblResult.Text = $"Converted Amount: {symbol}{converted:N2} {to}";
        }

        private string GetCurrencySymbol(string code)
        {
            switch (code?.ToUpperInvariant())
            {
                case "USD": return "$";
                case "PHP": return "₱";
                case "EUR": return "€";
                case "GBP": return "£";
                case "JPY": return "¥";
                case "INR": return "₨";
                case "CAD": return "C$";
                default: return string.Empty;
            }
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void lblResult_Click(object sender, EventArgs e)
        {

        }

        private void lblTo_Click(object sender, EventArgs e)
        {

        }
    }
}
