using Newtonsoft.Json;
using SuperNaaahi.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public class PuntuazioaService: IPuntuazioaService
    {
        private Uri rutaTodos = new Uri("http://192.168.65.7:8080/puntuazioak/");


        public async Task<List<Puntuazioa>> GetPuntuazioak()
        {
            List<Puntuazioa> puntuazioaList = new List<Puntuazioa>();

            using (var httpClient = new HttpClient())
            {
               using (var response = await httpClient.GetAsync(rutaTodos)) 
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<Puntuazioa>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
    }
}
