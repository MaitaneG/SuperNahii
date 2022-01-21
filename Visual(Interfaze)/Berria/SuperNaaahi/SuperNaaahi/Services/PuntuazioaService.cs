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


        public async Task<List<PuntuazioaModel>> GetPuntuazioak()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
               using (var response = await httpClient.GetAsync(rutaTodos)) 
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
        public async Task<List<PuntuazioaModel>> GetHallOfFame()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos+"hallOfFame/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
        public async Task<List<PuntuazioaModel>> GetHallOfShame()
        {
            List<PuntuazioaModel> puntuazioaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
                using (var response = await httpClient.GetAsync(rutaTodos + "hallOfShame/"))
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    puntuazioaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }
            }
            return puntuazioaList;
        }
    }
}
