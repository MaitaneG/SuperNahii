using SuperNaaahi.Models;

using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Threading.Tasks;

namespace SuperNaaahi.Services
{
    public class PuntuazioaService
    {
        public async Task<List<PuntuazioaModel>> GetArdoak()
        {
            List<PuntuazioaModel> ardoaList = new List<PuntuazioaModel>();

            using (var httpClient = new HttpClient())
            {
               /*using (var response = await httpClient.GetAsync(rutaTodos)) 
                {
                    string apiResponse = await response.Content.ReadAsStringAsync();
                    ardoaList = JsonConvert.DeserializeObject<List<PuntuazioaModel>>(apiResponse);
                }*/
            }
            return ardoaList;
        }
    }
}
